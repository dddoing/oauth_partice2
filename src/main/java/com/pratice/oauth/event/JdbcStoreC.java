package com.pratice.oauth.event;

import com.pratice.oauth.entity.Token;
import com.pratice.oauth.repo.TokenJpaRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.common.util.SerializationUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

@Slf4j
public class JdbcStoreC extends JdbcTokenStore {

    @Autowired
    TokenJpaRepo tokenJpaRepo;

    public JdbcStoreC(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        log.info("{}",token);
        log.info("{}",authentication);

        Token tokens = new Token();
        tokens.setAccessToken(extractTokenKey(token.getValue()));
        tokens.setRefreshToken(extractTokenKey(token.getRefreshToken().getValue()));
        tokens.setAuthenticateId("1123");
        tokens.setClientId(authentication.getOAuth2Request().getClientId());

        log.info("{}",tokens);
//        super.storeAccessToken(token, authentication);
        tokenJpaRepo.save(tokens);
    }

    @Override
    public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
        return super.getAccessToken(authentication);
    }

    @Override
    public OAuth2AccessToken readAccessToken(String tokenValue) {
        return super.readAccessToken(tokenValue);
    }

    @Override
    public void removeAccessToken(OAuth2AccessToken token) {
        super.removeAccessToken(token);
    }

    @Override
    public void removeAccessToken(String tokenValue) {
        super.removeAccessToken(tokenValue);
    }

    @Override
    public OAuth2Authentication readAuthentication(OAuth2AccessToken token) {
        return super.readAuthentication(token);
    }

    @Override
    public OAuth2Authentication readAuthentication(String token) {
        return super.readAuthentication(token);
    }

    @Override
    public void storeRefreshToken(OAuth2RefreshToken refreshToken, OAuth2Authentication authentication) {
        super.storeRefreshToken(refreshToken, authentication);
    }

    @Override
    public OAuth2RefreshToken readRefreshToken(String token) {
        return super.readRefreshToken(token);
    }

    @Override
    public void removeRefreshToken(OAuth2RefreshToken token) {
        super.removeRefreshToken(token);
    }

    @Override
    public void removeRefreshToken(String token) {
        super.removeRefreshToken(token);
    }

    @Override
    public OAuth2Authentication readAuthenticationForRefreshToken(OAuth2RefreshToken token) {
        return super.readAuthenticationForRefreshToken(token);
    }

    @Override
    public OAuth2Authentication readAuthenticationForRefreshToken(String value) {
        return super.readAuthenticationForRefreshToken(value);
    }

    @Override
    public void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken refreshToken) {
        super.removeAccessTokenUsingRefreshToken(refreshToken);
    }

    @Override
    public void removeAccessTokenUsingRefreshToken(String refreshToken) {
        super.removeAccessTokenUsingRefreshToken(refreshToken);
    }

    @Override
    public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) {
        return super.findTokensByClientId(clientId);
    }

    @Override
    public Collection<OAuth2AccessToken> findTokensByUserName(String userName) {
        return super.findTokensByUserName(userName);
    }

    @Override
    public Collection<OAuth2AccessToken> findTokensByClientIdAndUserName(String clientId, String userName) {
        return super.findTokensByClientIdAndUserName(clientId, userName);
    }

    protected String extractTokenKey(String value) {
        if (value == null) {
            return null;
        }
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 algorithm not available.  Fatal (should be in the JDK).");
        }

        try {
            byte[] bytes = digest.digest(value.getBytes("UTF-8"));
            return String.format("%032x", new BigInteger(1, bytes));
        }
        catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 encoding not available.  Fatal (should be in the JDK).");
        }
    }
}
