package com.pratice.oauth.config;
//
//import com.pratice.oauth.controller.CustomAuthorizationEndpoint;
//import com.pratice.oauth.controller.CustomEndpoint;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerEndpointsConfiguration;
//import org.springframework.security.oauth2.provider.endpoint.AuthorizationEndpoint;
//import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpointHandlerMapping;
//import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
//
//@Configuration
//public class CustomTokenEndpoint {
//
//    @Autowired
//    AuthorizationServerEndpointsConfiguration config;
//
//    @Bean
//    @Primary
//    public TokenEndpoint tokenEndpoint() throws Exception {
//        TokenEndpoint tokenEndpoint = new CustomEndpoint();
//        tokenEndpoint.setClientDetailsService(config.getEndpointsConfigurer().getClientDetailsService());
//        tokenEndpoint.setProviderExceptionHandler(config.getEndpointsConfigurer().getExceptionTranslator());
//        tokenEndpoint.setTokenGranter(config.getEndpointsConfigurer().getTokenGranter());
//        tokenEndpoint.setOAuth2RequestFactory(config.getEndpointsConfigurer().getOAuth2RequestFactory());
//        tokenEndpoint.setOAuth2RequestValidator(config.getEndpointsConfigurer().getOAuth2RequestValidator());
//        tokenEndpoint.setAllowedRequestMethods(config.getEndpointsConfigurer().getAllowedTokenEndpointRequestMethods());
//        return tokenEndpoint;
//    }
//
//    @Bean
//    @Primary
//    public AuthorizationEndpoint authorizationEndpoint() throws Exception {
//        AuthorizationEndpoint authorizationEndpoint = new CustomAuthorizationEndpoint();
//        FrameworkEndpointHandlerMapping mapping = config.getEndpointsConfigurer().getFrameworkEndpointHandlerMapping();
//        authorizationEndpoint.setUserApprovalPage(extractPath(mapping, "/oauth/confirm_access"));
//        authorizationEndpoint.setProviderExceptionHandler(config.getEndpointsConfigurer().getExceptionTranslator());
//        authorizationEndpoint.setErrorPage(extractPath(mapping, "/oauth/error"));
//        authorizationEndpoint.setTokenGranter(config.getEndpointsConfigurer().getTokenGranter());
//        authorizationEndpoint.setClientDetailsService(config.getEndpointsConfigurer().getClientDetailsService());
//        authorizationEndpoint.setAuthorizationCodeServices(config.getEndpointsConfigurer().getAuthorizationCodeServices());
//        authorizationEndpoint.setOAuth2RequestFactory(config.getEndpointsConfigurer().getOAuth2RequestFactory());
//        authorizationEndpoint.setOAuth2RequestValidator(config.getEndpointsConfigurer().getOAuth2RequestValidator());
//        authorizationEndpoint.setUserApprovalHandler(config.getEndpointsConfigurer().getUserApprovalHandler());
//        authorizationEndpoint.setRedirectResolver(config.getEndpointsConfigurer().getRedirectResolver());
//        return authorizationEndpoint;
//    }
//
//    private String extractPath(FrameworkEndpointHandlerMapping mapping, String page) {
//        String path = mapping.getPath(page);
//        if (path.contains(":")) {
//            return path;
//        }
//        return "forward:" + path;
//    }
//
//}
