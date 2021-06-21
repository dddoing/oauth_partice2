package com.pratice.oauth.config;

import com.pratice.oauth.entity.Client;
import com.pratice.oauth.repo.ClientJpaRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JWTAccessTokenConverter extends JwtAccessTokenConverter {

    @Autowired
    ClientJpaRepo clientJpaRepo;


    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        //
        Map<String,Object> addAccessToken = new HashMap<>();

        // /oauth/token : response
        // access_token add
        addAccessToken.put("iss","metlife");
//        addAccessToken.put("aud","org_code");
        ((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(addAccessToken);

        accessToken = super.enhance(accessToken,authentication);

        //refresh_token_expires
        Client client = clientJpaRepo.findByClientId(authentication.getName());
        // response add
        Map<String,Object> addResponseToken = new HashMap<>();

//        addResponseToken.put("refresh_token_expires_in",client.getRefreshTokenValiditySeconds());
        addResponseToken.put("refresh_token_expires_in",60);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(addResponseToken);

        return accessToken;
    }
}
