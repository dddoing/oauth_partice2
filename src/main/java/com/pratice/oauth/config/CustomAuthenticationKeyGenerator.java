package com.pratice.oauth.config;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;

public class CustomAuthenticationKeyGenerator implements AuthenticationKeyGenerator {
    //
    private static final String CLIENT_ID = "client_id";

    private static final String SCOPE = "scope";


    @Override
    public String extractKey(OAuth2Authentication authentication) {
        //
        return null;
    }
}
