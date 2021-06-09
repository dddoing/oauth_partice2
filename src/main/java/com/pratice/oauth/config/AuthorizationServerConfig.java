package com.pratice.oauth.config;

//import com.pratice.oauth.event.CustomClientDetailsService;
import com.pratice.oauth.event.CustomUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Arrays;

@Configuration
@EnableAuthorizationServer
@Slf4j
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    //
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;
    @Autowired
    private OAuth2RequestFactory requestFactory;
//    @Autowired
//    private CustomClientDetailsService clientDetailsService;
    @Autowired
    private ServiceConfig serviceConfig;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()") //allow check token
                .allowFormAuthenticationForClients();
    }

    // change DB management
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //
                clients.inMemory()
                .withClient(serviceConfig.getClient().getId())
                .secret(passwordEncoder.encode(serviceConfig.getClient().getSecret()))
                .authorizedGrantTypes(serviceConfig.getGrantTypes().toArray(new String[0]))
                .scopes("read","write")
                .accessTokenValiditySeconds(60)
                .refreshTokenValiditySeconds(120)
                .redirectUris(serviceConfig.getRedirectUrl())
                .autoApprove(true);
//        clients.withClientDetails(clientDetailsService);
    }

    //
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //
        endpoints
//                .pathMapping("/oauth/token","/oauth2/token")
                .authenticationManager(authenticationManager)
                .accessTokenConverter(jwtAccessTokenConverter)
                .tokenStore(tokenStore)
                .userDetailsService(userDetailsService)
                .requestFactory(requestFactory);
    }
}
