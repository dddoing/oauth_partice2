package com.pratice.oauth.event;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomClientDetailsService implements ClientDetailsService {
    //
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        return new BaseClientDetails("testClient","org_code","read","authorization_code,refresh_code","");
    }
}
