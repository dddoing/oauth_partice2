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

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Scanner;

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

        User user = userJpaRepo.findByUid(username).orElseThrow(()->new UsernameNotFoundException("no"));

        log.info("provider in");
//
        if (!passwordEncoder.matches(userPassword,user.getPassword())) {
            throw new BadCredentialsException("wrong Password");
        }

        return new UsernamePasswordAuthenticationToken(username,userPassword,user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    ///// aud >> org_code
    private void printRequest(HttpServletRequest httpRequest) {
        System.out.println(" \n\n Headers");

        Enumeration headerNames = httpRequest.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = (String)headerNames.nextElement();
            System.out.println(headerName + " = " + httpRequest.getHeader(headerName));
        }

        System.out.println("\n\nParameters");

        Enumeration params = httpRequest.getParameterNames();
        while(params.hasMoreElements()){
            String paramName = (String)params.nextElement();
            System.out.println(paramName + " = " + httpRequest.getParameter(paramName));
        }

        System.out.println("\n\n Row data");
        System.out.println(extractPostRequestBody(httpRequest));
    }

    static String extractPostRequestBody(HttpServletRequest request) {
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            Scanner s = null;
            try {
                s = new Scanner(request.getInputStream(), "UTF-8").useDelimiter("\\A");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s.hasNext() ? s.next() : "";
        }
        return "";
    }
}
