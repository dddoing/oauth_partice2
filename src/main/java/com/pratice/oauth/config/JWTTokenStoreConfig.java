package com.pratice.oauth.config;

import com.pratice.oauth.event.CustomClientDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class JWTTokenStoreConfig {
    //
    private final ServiceConfig serviceConfig;
    private final CustomClientDetailsService clientDetailsService;

    @Bean
    public TokenStore tokenStore() {
        //
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        //
        JWTAccessTokenConverter converter = new JWTAccessTokenConverter();
        converter.setSigningKey(serviceConfig.getJwtSigningKey());

        return converter;
    }

    //
    @Bean
    @Primary
    public DefaultTokenServices defaultTokenServices() {
        //
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore());
        tokenServices.setSupportRefreshToken(true);

        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtAccessTokenConverter()));
        tokenServices.setTokenEnhancer(tokenEnhancerChain);


        return tokenServices;
    }

    @Bean
    public OAuth2RequestFactory requestFactory() {
        return new CustomRequestFactory(clientDetailsService);
    }

}
