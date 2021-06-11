package com.pratice.oauth.config;

//import com.pratice.oauth.event.JdbcStoreC;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class JWTTokenStoreConfig {
    //
    private final ServiceConfig serviceConfig;
    private final DataSource dataSource;

    @Bean
    public TokenStore tokenStore() {
        //
//        return new JwtTokenStore(jwtAccessTokenConverter());
//        return new JdbcStoreC(dataSource);
        return new JdbcTokenStore(dataSource);
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
//        CustomTokenService tokenServices = new CustomTokenService();
        tokenServices.setTokenStore(tokenStore());
        tokenServices.setSupportRefreshToken(true);


        return tokenServices;
    }

}
