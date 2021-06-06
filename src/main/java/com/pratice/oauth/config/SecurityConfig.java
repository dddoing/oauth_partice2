package com.pratice.oauth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@Slf4j
public class SecurityConfig extends ResourceServerConfigurerAdapter {
    //

    @Override
    public void configure(HttpSecurity http) throws Exception {

        log.info("ResourceServerConfigurerAdapter");
        http
                .authorizeRequests()
//                .antMatchers("/oauth2/**","/oauth/**","/login","/h2-console/*").permitAll()
//                .antMatchers("/**").permitAll()
//                .and().formLogin();
                .anyRequest().authenticated();
    }

}
