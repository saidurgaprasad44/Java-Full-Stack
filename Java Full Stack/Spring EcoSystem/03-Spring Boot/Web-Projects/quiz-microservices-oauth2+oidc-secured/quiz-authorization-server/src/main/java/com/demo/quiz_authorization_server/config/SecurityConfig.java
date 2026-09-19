package com.demo.quiz_authorization_server.config;

import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.MediaTypeRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    @Order(1) // This makes this chain the first candidate.
    // This filter chain is only responsible for requests belonging to the Authorization Server endpoints such as /oauth2/authorize/oauth2/token, /oauth2/jwks, /oauth2/introspect, /oauth2/revoke, /.well-known/oauth-authorization-server
    SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http) throws Exception {
        
        http
        	.oauth2AuthorizationServer(authorizationServer -> {
        		
        		http.securityMatcher(authorizationServer.getEndpointsMatcher()); // means "This filter chain is only responsible for requests belonging to the Authorization Server endpoints such as /oauth2/authorize/oauth2/token, /oauth2/jwks, /oauth2/introspect, /oauth2/revoke, /.well-known/oauth-authorization-server

        		authorizationServer.oidc(Customizer.withDefaults()); // Enabling OpenID Connect functionality. Therefore we get OIDC functionality such as: /.well-known/openid-configuration, /userinfo and /logout
        	})
        	
        	.authorizeHttpRequests(authorize -> authorize
        		.anyRequest().authenticated() // All requests to the Authorization Server endpoints must be authenticated, if not authenticated AuthenticationEntryPoint will be triggered and the user will be redirected to the /login.
        	)
        
        	.exceptionHandling(exceptions -> exceptions
        	    .defaultAuthenticationEntryPointFor(
        	        new LoginUrlAuthenticationEntryPoint("/login"),
        	        new MediaTypeRequestMatcher(MediaType.TEXT_HTML)
        	    )
        	);

        return http.build();
    }
    
    @Bean
    @Order(2) // this chain is the second candidate for user login.
    SecurityFilterChain applicationSecurityFilterChain(
            HttpSecurity http) throws Exception {

    	http
        	.authorizeHttpRequests(authorize ->
            	authorize
                	.requestMatchers("/login").permitAll()
                	.anyRequest().authenticated()
        	)
        	
        	.formLogin(Customizer.withDefaults());

    	return http.build();
    }
    
    @Bean
    RegisteredClientRepository registeredClientRepository() {

        RegisteredClient quizFrontendClient  = RegisteredClient
        				.withId(UUID.randomUUID().toString())
                        .clientId("quiz-frontend")
                        .clientAuthenticationMethod(
                                ClientAuthenticationMethod.NONE //It is intentional because we're using Authorization Code + PKCE with a public client
                        )
                        .authorizationGrantType(
                                AuthorizationGrantType.AUTHORIZATION_CODE //Authentication Code Grant Type is used for the Authorization Code Flow with PKCE
                        )
                        .authorizationGrantType(
                                AuthorizationGrantType.REFRESH_TOKEN 
                        )
                        .redirectUri("http://localhost:3000/callback")
                        .scope(OidcScopes.OPENID) // this will issue the ID token
                        .scope(OidcScopes.PROFILE)
                        .scope(OidcScopes.EMAIL)
                        .build();
        
        RegisteredClient quizServiceClient = RegisteredClient
        			.withId(UUID.randomUUID().toString())
                    .clientId("quiz-service")
                    .clientSecret(passwordEncoder().encode("quiz-service-secret"))
                    .clientAuthenticationMethod(
                        ClientAuthenticationMethod.CLIENT_SECRET_BASIC
                    )
                    .authorizationGrantType(
                        AuthorizationGrantType.CLIENT_CREDENTIALS
                    )
                    .scope("question.generate")
                    .scope("question.read")
                    .scope("question.evaluate")
                    .build();
        
     // Authorization server will store the registered client in memory. In production, you would typically use a database to store registered clients.
        return new InMemoryRegisteredClientRepository(quizFrontendClient, quizServiceClient); 
    }
    
    @Bean
    OAuth2TokenCustomizer<JwtEncodingContext> jwtTokenCustomizer() {
    	return context -> {

            if (!OAuth2TokenType.ACCESS_TOKEN.equals(context.getTokenType())) {
                return;
            }

            Authentication authentication = context.getPrincipal();

            // User-based token
            if (AuthorizationGrantType.AUTHORIZATION_CODE.equals(
                    context.getAuthorizationGrantType())) {

                List<String> roles = authentication.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .filter(authority -> authority.startsWith("ROLE_"))
                        .map(authority -> authority.substring(5))
                        .toList();

                context.getClaims().claim("roles", roles);
            }
        };
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
