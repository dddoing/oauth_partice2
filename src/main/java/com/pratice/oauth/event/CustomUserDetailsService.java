package com.pratice.oauth.event;

import com.pratice.oauth.entity.User;
import com.pratice.oauth.repo.UserJpaRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
    //
    @Autowired
    private UserJpaRepo userJpaRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //
        User user = userJpaRepo.findByUid(username).orElseThrow(()-> new UsernameNotFoundException("not exists"));
        log.info("userDetailsService");

        return user;
    }
}
