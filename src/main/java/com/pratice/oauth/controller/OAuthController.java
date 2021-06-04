package com.pratice.oauth.controller;

import com.google.gson.Gson;
import com.pratice.oauth.event.CustomAuthenticationProvider;
import com.pratice.oauth.model.OAuthToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/oauth2")
@RequiredArgsConstructor
@Slf4j
public class OAuthController {

    private final Gson gson;
    private final RestTemplate restTemplate;

    @GetMapping(value = "/callback")
    public OAuthToken callback(@RequestParam String code,@RequestParam String state) {
        //
        String credentials = "testClientId:testSecret";
        String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

        System.out.println(code+state);
//        //token
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        headers.add("Accept",MediaType.APPLICATION_JSON_VALUE);
//        headers.add("Authorization","Basic "+encodedCredentials);
//
//        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
//        params.add("code",code);
//        params.add("grant_type","authorization_code");
//        params.add("redirect_uri","http://localhost:8081/oauth2/callback");
//
//        HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(params,headers);
//        log.info("request : {}",request);
//        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8081/oauth/token",request,String.class);
//        log.info("response: {}",response);
//
//        if (response.getStatusCode() == HttpStatus.OK) {
//            return gson.fromJson(response.getBody(), OAuthToken.class);
//        }

        return null;
    }

}
