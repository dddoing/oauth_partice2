package com.pratice.oauth.event;

import com.pratice.oauth.entity.User;
import com.pratice.oauth.repo.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomAuthenticationProvider implements AuthenticationProvider {
    //
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserJpaRepo userJpaRepo;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //
        String username = authentication.getName();
        String userPassword = authentication.getCredentials().toString();

//        User user = userJpaRepo.findByUid(username).orElseThrow(()->new UsernameNotFoundException("no"));
//
        log.info("Authentication Info : {}", authentication);
        log.info("username:{},userPassword:{}",username,userPassword);
//
//        if (!passwordEncoder.matches(userPassword,user.getPassword())) {
//            throw new BadCredentialsException("wrong Password");
//        }

//        return new UsernamePasswordAuthenticationToken(username,userPassword,user.getAuthorities());
        return new UsernamePasswordAuthenticationToken(username,userPassword,null);
    }

    @Override
    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
        return true;
    }
}
