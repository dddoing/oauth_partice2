package com.pratice.oauth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableResourceServer
@Slf4j
public class SecurityConfig extends ResourceServerConfigurerAdapter {
    //

    @Override
    public void configure(HttpSecurity http) throws Exception {

        log.info("ResourceServerConfigurerAdapter");
        http
//                .authorizeRequests()
//                .antMatchers("/oauth2/**","/oauth/**","/login","/h2-console/*").permitAll()
//                .antMatchers("/**").permitAll()
//                .and().formLogin();
//                .anyRequest().authenticated();
            .requestMatcher(new OAuthRequestedMatcher())
                .authorizeRequests()
                .anyRequest().fullyAuthenticated();
    }

    private static class OAuthRequestedMatcher implements RequestMatcher {
        //
        public boolean matches(HttpServletRequest request) {
            //
            String auth = request.getHeader("Authorization");
            boolean haveOauth2Token = (auth != null) && auth.toLowerCase().startsWith("bearer");
            boolean haveAccessToken = request.getParameter("access_token") != null;
            log.info("havToken : {} , haveAccess : {}",haveOauth2Token,haveAccessToken);
            return haveOauth2Token || haveAccessToken;
        }
    }
}
