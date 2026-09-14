package com.demo.quiz_service.config;

import java.security.interfaces.RSAPublicKey;
import java.security.interfaces.RSAPrivateKey;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;

import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
        	.csrf(csrf -> csrf.disable())
        	
            .authorizeHttpRequests(auth -> auth
            	.requestMatchers("/auth/login").permitAll()
                .anyRequest().authenticated()
            )
            
//            .oauth2ResourceServer(oauth2 -> oauth2
//            	.jwt(Customizer.withDefaults())
//            ); //means "Use JWT Bearer authentication for incoming requests."
            .oauth2ResourceServer(oauth2 -> oauth2
            	.jwt(jwt -> jwt
            		.jwtAuthenticationConverter(jwtAuthenticationConverter())
            	)
            );
        return http.build();
    }
	
	@Bean
	public JwtAuthenticationConverter jwtAuthenticationConverter() {

	    JwtGrantedAuthoritiesConverter authoritiesConverter = new JwtGrantedAuthoritiesConverter();

	    authoritiesConverter.setAuthoritiesClaimName("roles");
	    authoritiesConverter.setAuthorityPrefix("");

	    JwtAuthenticationConverter converter =
	            new JwtAuthenticationConverter();

	    converter.setJwtGrantedAuthoritiesConverter(authoritiesConverter);

	    return converter;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)throws Exception {

	    return configuration.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
    public JwtEncoder jwtEncoder(RSAPublicKey publicKey, RSAPrivateKey privateKey) {

        JWK jwk = new RSAKey.Builder(publicKey) //Putting both public and private keys in the JWK object
                .privateKey(privateKey)
                .build();

        JWKSource<com.nimbusds.jose.proc.SecurityContext> jwkSource = new ImmutableJWKSet<>(new JWKSet(jwk));

        return new NimbusJwtEncoder(jwkSource);
    }
	
	@Bean
	public JwtDecoder jwtDecoder(RSAPublicKey publicKey) {
	    return NimbusJwtDecoder
	            .withPublicKey(publicKey)
	            .build();
	}
	
}
