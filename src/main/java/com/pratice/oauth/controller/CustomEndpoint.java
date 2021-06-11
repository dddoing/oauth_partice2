package com.pratice.oauth.controller;

import com.pratice.oauth.repo.ClientJpaRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.approval.Approval;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Slf4j
public class CustomEndpoint extends TokenEndpoint {

    @Autowired
    DefaultTokenServices defaultTokenServices;
    @Autowired
    ClientJpaRepo clientJpaRepo;

    @RequestMapping(value = "/oauth/revoke",method=RequestMethod.POST)
    public ResponseEntity revokeToken(@RequestParam Map<String, String> parameters) {

        log.info("???????????");
//        Authentication client = (Authentication) principal;
//        log.info("{}",client.getName());
//        log.info("{}",parameters);
        if (parameters.get("client_id") == null || parameters.get("client_secret") == null) {
            //
            throw new BadCredentialsException("No client credentials presented");
        }

        String clientId = parameters.get("client_id");

//        if (clientJpaRepo.findByClientId(clientId) == null) {
        if (clientJpaRepo.findByClientId("sample@test.com") == null) {
            //
            throw new BadCredentialsException("No client credentials presented");
        }

//        String tokenValue = parameters.get("token");
//        defaultTokenServices.revokeToken(tokenValue);

      return new ResponseEntity("000000",HttpStatus.OK);
    }
}
