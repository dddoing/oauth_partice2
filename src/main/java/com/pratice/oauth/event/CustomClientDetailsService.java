//package com.pratice.oauth.event;
//
//import com.pratice.oauth.entity.Client;
//import com.pratice.oauth.repo.ClientJpaRepo;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.oauth2.provider.ClientDetails;
//import org.springframework.security.oauth2.provider.ClientDetailsService;
//import org.springframework.security.oauth2.provider.ClientRegistrationException;
//import org.springframework.security.oauth2.provider.client.BaseClientDetails;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//public class CustomClientDetailsService implements ClientDetailsService {
//    //
//    @Autowired
//    private ClientJpaRepo clientJpaRepo;
//
//    @Override
//    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
//
//        Client client = clientJpaRepo.findByClientId(clientId);
//        BaseClientDetails baseClient = new BaseClientDetails(client);
//
//        baseClient.setAutoApproveScopes(client.getScope());
//
//        return baseClient;
//    }
//}
