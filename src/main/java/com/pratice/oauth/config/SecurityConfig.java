//package com.pratice.oauth.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
//@Configuration
//public class SecurityConfig extends ResourceServerConfigurerAdapter {
//    //
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
////                .antMatchers("/oauth2/**","/oauth/**","/login","/h2-console/*").permitAll()
//                .antMatchers("/oauth/**","/oauth2/**","/h2-console/*","/login").permitAll()
//                .anyRequest()
//                .authenticated();
//    }
//}
