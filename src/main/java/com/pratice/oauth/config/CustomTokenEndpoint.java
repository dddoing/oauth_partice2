package com.pratice.oauth.config;

import com.pratice.oauth.controller.CustomEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerEndpointsConfiguration;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;

@Configuration
public class CustomTokenEndpoint {

    @Bean
    @Primary
    public TokenEndpoint tokenEndpoint(AuthorizationServerEndpointsConfiguration config) throws Exception {
        TokenEndpoint tokenEndpoint = new CustomEndpoint();
        tokenEndpoint.setClientDetailsService(config.getEndpointsConfigurer().getClientDetailsService());
        tokenEndpoint.setProviderExceptionHandler(config.getEndpointsConfigurer().getExceptionTranslator());
        tokenEndpoint.setTokenGranter(config.getEndpointsConfigurer().getTokenGranter());
        tokenEndpoint.setOAuth2RequestFactory(config.getEndpointsConfigurer().getOAuth2RequestFactory());
        tokenEndpoint.setOAuth2RequestValidator(config.getEndpointsConfigurer().getOAuth2RequestValidator());
        tokenEndpoint.setAllowedRequestMethods(config.getEndpointsConfigurer().getAllowedTokenEndpointRequestMethods());
        return tokenEndpoint;
    }
}
