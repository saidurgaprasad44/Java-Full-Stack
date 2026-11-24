package com.demo.question_service.config;




import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)
	        throws Exception {

	    http
	    	.csrf(csrf -> csrf.disable())
	    	
	        .authorizeHttpRequests(auth -> auth
	            .anyRequest().authenticated()
	        )
	        
	        .exceptionHandling(exceptions -> exceptions
	            .authenticationEntryPoint(authenticationEntryPoint())
	            .accessDeniedHandler(accessDeniedHandler())
	        )
	        
	        //means "Use JWT Bearer authentication for incoming requests and convert the JWT claims to Spring Security authorities using the specified JwtAuthenticationConverter."
	        .oauth2ResourceServer(oauth2 -> oauth2
	        	.jwt(jwt -> jwt
	        		.jwtAuthenticationConverter(jwtAuthenticationConverter())
	        	)
	        ); 

	    return http.build();
	}
    
	
    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {

    	//for quiz-service access token's scope claim conversion
    	JwtGrantedAuthoritiesConverter scopeConverter = new JwtGrantedAuthoritiesConverter();

    	//for user access token's role claim conversion
        JwtGrantedAuthoritiesConverter roleConverter = new JwtGrantedAuthoritiesConverter();

        roleConverter.setAuthoritiesClaimName("roles");
        roleConverter.setAuthorityPrefix("ROLE_");

        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();

        converter.setJwtGrantedAuthoritiesConverter(jwt -> {
        	Collection<GrantedAuthority> authorities = new ArrayList<>();

            authorities.addAll(scopeConverter.convert(jwt));
            authorities.addAll(roleConverter.convert(jwt));

            return authorities;
        });

        return converter;
    }
    
    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, authException) -> {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("""
                {
                    "status": 401,
                    "error": "Unauthorized",
                    "message": "Authentication is required"
                }
                """);
        };
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json");
            response.getWriter().write("""
                {
                    "status": 403,
                    "error": "Forbidden",
                    "message": "You do not have permission to access this resource"
                }
                """);
        };
    }
}
