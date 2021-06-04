package com.pratice.oauth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JWTTokenEnhancer implements TokenEnhancer {

    //token
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        //
        Map<String,Object> additionalInfo = new HashMap<>();

        //
        additionalInfo.put("iss","metlife");
        additionalInfo.put("aud","org_code");

        log.info("jwtAccessTokenEnhancer");

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);

        return accessToken;
    }


}
