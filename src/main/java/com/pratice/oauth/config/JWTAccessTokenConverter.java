package com.pratice.oauth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
        Map<String,Object> addAccessToken = new HashMap<>();

        // /oauth/token : response
        // access_token add
        addAccessToken.put("iss","metlife");
//        add.put()
        ((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(addAccessToken);

        accessToken = super.enhance(accessToken,authentication);

        // response add
        Map<String,Object> addResponseToken = new HashMap<>();
        addResponseToken.put("refresh_token_expires_in",123);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(addResponseToken);

        return accessToken;
    }
}
