package com.pratice.oauth.model;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

public class OAuthToken extends DefaultOAuth2AccessToken {
    //
    public OAuthToken(OAuth2AccessToken accessToken) {
        super(accessToken);
    }

}
