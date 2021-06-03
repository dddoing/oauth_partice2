package com.pratice.oauth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JWTAccessTokenConverter extends JwtAccessTokenConverter {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        //
        Map<String,Object> add = new HashMap<>();
        // /oauth/token response
        // TODO: refresh_token : 유효시간 설정
        log.info("?{}",authentication);

        ((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(add);

        return super.enhance(accessToken, authentication);
    }
}
