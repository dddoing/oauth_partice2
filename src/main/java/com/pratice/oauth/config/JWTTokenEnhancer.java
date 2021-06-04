//package com.pratice.oauth.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.security.oauth2.provider.token.TokenEnhancer;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//@Slf4j
//public class JWTTokenEnhancer implements TokenEnhancer {
//
//    //token
//    @Override
//    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
//
//        //
//        Map<String,Object> additionalInfo = new HashMap<>();
//
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        printRequest(request);
//
//        //
//        additionalInfo.put("iss","metlife");
//        additionalInfo.put("aud","org_code");
//
//        log.info("jwtAccessTokenEnhancer");
//
//        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
//
//        return accessToken;
//    }
//
//    private void printRequest(HttpServletRequest httpRequest) {
//        System.out.println(" \n\n Headers");
//
//        Enumeration headerNames = httpRequest.getHeaderNames();
//        while(headerNames.hasMoreElements()) {
//            String headerName = (String)headerNames.nextElement();
//            System.out.println(headerName + " = " + httpRequest.getHeader(headerName));
//        }
//
//        System.out.println("\n\nParameters");
//
//        Enumeration params = httpRequest.getParameterNames();
//        while(params.hasMoreElements()){
//            String paramName = (String)params.nextElement();
//            System.out.println(paramName + " = " + httpRequest.getParameter(paramName));
//        }
//
//        System.out.println("\n\n Row data");
//        System.out.println(extractPostRequestBody(httpRequest));
//    }
//
//    static String extractPostRequestBody(HttpServletRequest request) {
//        if ("POST".equalsIgnoreCase(request.getMethod())) {
//            Scanner s = null;
//            try {
//                s = new Scanner(request.getInputStream(), "UTF-8").useDelimiter("\\A");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return s.hasNext() ? s.next() : "";
//        }
//        return "";
//    }
//
//}
