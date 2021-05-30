package com.pratice.oauth.config;

import com.pratice.oauth.event.CustomAuthenticationProvider;
import com.pratice.oauth.event.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //
    @Autowired
    private CustomAuthenticationProvider authenticationProvider;
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //
        auth.authenticationProvider(authenticationProvider)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        //
        security
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests().antMatchers("/oauth/**", "/oauth/token", "/oauth2/**", "/h2-console/*","/login").permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    //fixme: bycrptPassword
    @Bean
    public PasswordEncoder passwordEncoder() {
        //
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public RestTemplate restTemplate() {
        //
        return new RestTemplate();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
