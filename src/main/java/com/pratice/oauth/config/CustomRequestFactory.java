package com.pratice.oauth.config;

//import com.pratice.oauth.event.CustomClientDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;

import java.util.Map;

@Slf4j
public class    CustomRequestFactory extends DefaultOAuth2RequestFactory {

    public CustomRequestFactory(ClientDetailsService clientDetailsService) {
        super(clientDetailsService);
    }
    //

    // /oauth/authorize
    @Override
    public AuthorizationRequest createAuthorizationRequest(Map<String, String> authorizationParameters) {

        if (authorizationParameters.get("org_code") == null) {
            log.info("non org_code");
        }

        return super.createAuthorizationRequest(authorizationParameters);
    }


    // /oauth/token
    @Override
    public TokenRequest createTokenRequest(Map<String, String> requestParameters, ClientDetails authenticatedClient) {
        //

        if (requestParameters.get("org_code") == null) {
            log.info("non org_code");
        }
        return super.createTokenRequest(requestParameters, authenticatedClient);
    }
}
