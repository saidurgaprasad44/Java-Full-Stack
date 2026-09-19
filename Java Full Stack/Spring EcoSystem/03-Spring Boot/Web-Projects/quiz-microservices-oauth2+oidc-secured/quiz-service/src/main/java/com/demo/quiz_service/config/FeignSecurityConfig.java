package com.demo.quiz_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

import feign.RequestInterceptor;

@Configuration
public class FeignSecurityConfig {

	@Bean
	// obtain → cache → reuse → expire → obtain new token
    RequestInterceptor oauth2FeignRequestInterceptor(OAuth2AuthorizedClientManager authorizedClientManager) {

        return requestTemplate -> {

            OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest
                            .withClientRegistrationId("question-service")
                            .principal("quiz-service")
                            .build();

            OAuth2AuthorizedClient authorizedClient = authorizedClientManager.authorize(authorizeRequest);

            if (authorizedClient == null) {
                throw new IllegalStateException(
                        "Failed to obtain OAuth2 access token"
                );
            }

            String accessToken = authorizedClient.getAccessToken().getTokenValue();

            requestTemplate.header(
                    "Authorization",
                    "Bearer " + accessToken
            );
        };
    }
}