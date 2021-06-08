package com.pratice.oauth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
public class CustomTokenService extends DefaultTokenServices {
    //

    // access_token expires check
    @Override
    public OAuth2Authentication loadAuthentication(String accessTokenValue) throws AuthenticationException, InvalidTokenException {
        log.info("??");
        return super.loadAuthentication(accessTokenValue);
    }
}
