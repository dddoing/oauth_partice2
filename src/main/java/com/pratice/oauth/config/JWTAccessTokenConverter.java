//package com.pratice.oauth.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Slf4j
//public class JWTAccessTokenConverter extends JwtAccessTokenConverter {
//
//    @Override
//    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
//        //
//        log.info("{}",accessToken.getAdditionalInformation());
//        Map<String,Object> add = new HashMap<>();
//        // /oauth/token : response
//        // TODO: refresh_token : 유효시간 설정
//        add.put("refresh_token_expires_in",11);
//        ((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(add);
//
//        log.info("{}",accessToken.getAdditionalInformation());
//        log.info("jwtAccessTokenConverter");
//
////        OAuth2AccessToken jwtToken = super.enhance(accessToken, authentication);
////
////        JWTTokenEnhancer jwt = new JWTTokenEnhancer();
////        OAuth2AccessToken auth2AccessToken = jwt.enhance(jwtToken,authentication);
//
//        return super.enhance(accessToken,authentication);
//
//    }
//}
