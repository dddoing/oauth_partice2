package com.pratice.oauth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Map;

@Slf4j
public class CustomEndpoint extends TokenEndpoint {

    @RequestMapping(value = "/oauth/revoke",method=RequestMethod.POST)
    public ResponseEntity sample(Principal principal, @RequestParam Map<String, String> parameters) {

        log.info("???????????");
        log.info("{}",principal);
        Authentication client = (Authentication) principal;
//        log.info("{}",client.getName());
        log.info("{}",parameters);
      return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/oauth/token", method=RequestMethod.POST)
    public ResponseEntity<OAuth2AccessToken> postAccessToken(Principal principal, @RequestParam
            Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        log.info("???????????");
        log.info("{}",principal);
        Authentication client = (Authentication) principal;
        log.info("{}",client.getName());
        log.info("{}",parameters);
        return super.postAccessToken(principal, parameters);
    }

    @RequestMapping(value = "/oauth/token", method=RequestMethod.GET)
    public ResponseEntity<OAuth2AccessToken> getAccessToken(Principal principal, @RequestParam
            Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {

        log.info("{}",principal);
        Authentication client = (Authentication) principal;
        log.info("{}",client.getName());
        log.info("{}",parameters);
        return postAccessToken(principal, parameters);
    }
}
