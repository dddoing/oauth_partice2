//package com.pratice.oauth.config;
//
//import com.pratice.oauth.entity.User;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
//
//import java.util.Map;
//
//
//public class CustomUserAuthenticationConverter extends DefaultUserAuthenticationConverter {
//    @Override
//    public Map<String, ?> convertUserAuthentication(Authentication authentication) {
//        //
//        Map<String,Object> response = (Map<String, Object>) super.convertUserAuthentication(authentication);
//
//        User user = (User) authentication.getPrincipal();
//        response.put("a", user.getName());
//
//        return response;
//    }
//}
