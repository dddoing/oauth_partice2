package com.pratice.oauth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class JWTTokenStoreConfig {
    //
    private final ServiceConfig serviceConfig;

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

    //?? tokenAccess??
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

}
