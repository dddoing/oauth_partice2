package com.pratice.oauth.controller;

import com.pratice.oauth.repo.ClientJpaRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
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
        //

        // 1.client_id, client_secret param check
        if (parameters.get("client_id") == null || parameters.get("client_secret") == null) {
            //
            throw new BadCredentialsException("No client credentials presented");
        }

        String clientId = parameters.get("client_id");

        // 2.authenticate check?
//        if (clientJpaRepo.findByClientId(clientId) == null) {
        if (clientJpaRepo.findByClientId("sample@test.com") == null) {
            //
            throw new BadCredentialsException("No client credentials presented");
        }

//        Authentication auth =

        // 3.access_token check
        String tokenValue = parameters.get("token");
        defaultTokenServices.revokeToken(tokenValue);

        // 4.delete token

      return new ResponseEntity("000000",HttpStatus.OK);
    }
}
