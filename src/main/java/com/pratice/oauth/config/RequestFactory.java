package com.pratice.oauth.config;

import com.pratice.oauth.event.CustomClientDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;

import java.util.Map;

@Slf4j
public class RequestFactory extends DefaultOAuth2RequestFactory {

    public RequestFactory(ClientDetailsService clientDetailsService) {
        super(new CustomClientDetailsService());
    }
    //

//    @Override
//    public AuthorizationRequest createAuthorizationRequest(Map<String, String> authorizationParameters) {
//
//        if (authorizationParameters.get("org_code") == null) {
//            log.info("hi");
//        }
//
//        return super.createAuthorizationRequest(authorizationParameters);
//    }


    //validate org_code
    @Override
    public TokenRequest createTokenRequest(Map<String, String> requestParameters, ClientDetails authenticatedClient) {
        //

        log.info("{}",requestParameters);
        log.info("{}",requestParameters.get("org_code"));
        if (requestParameters.get("org_code") == null) {
            log.info("ssi_bal");
        }
        return super.createTokenRequest(requestParameters, authenticatedClient);
    }
}
