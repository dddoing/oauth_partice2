//package com.pratice.oauth.event;
//
//import com.pratice.oauth.entity.Token;
//import com.pratice.oauth.repo.TokenJpaRepo;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.support.SqlLobValue;
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//import org.springframework.security.oauth2.common.util.SerializationUtils;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//
//import javax.sql.DataSource;
//import java.io.UnsupportedEncodingException;
//import java.math.BigInteger;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//
//@Slf4j
//public class JdbcStoreC extends JdbcTokenStore {
//
//    @Autowired
//    TokenJpaRepo tokenJpaRepo;
//
//    public JdbcStoreC(DataSource dataSource) {
//        super(dataSource);
//    }
//
//    @Override
//    public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
//        log.info("{}",token);
//        log.info("{}",authentication);
//
//        Token tokens = new Token();
//        tokens.setAccessToken(extractTokenKey(token.getValue()));
//        tokens.setRefreshToken(extractTokenKey(token.getRefreshToken().getValue()));
//        tokens.setAuthenticateId("1123");
//        tokens.setClientId(authentication.getOAuth2Request().getClientId());
//        tokens.setUserId(authentication.getName());
//
//        log.info("{}",tokens);
////        super.storeAccessToken(token, authentication);
//        tokenJpaRepo.save(tokens);
//    }
//
//    protected String extractTokenKey(String value) {
//        if (value == null) {
//            return null;
//        }
//        MessageDigest digest;
//        try {
//            digest = MessageDigest.getInstance("MD5");
//        }
//        catch (NoSuchAlgorithmException e) {
//            throw new IllegalStateException("MD5 algorithm not available.  Fatal (should be in the JDK).");
//        }
//
//        try {
//            byte[] bytes = digest.digest(value.getBytes("UTF-8"));
//            return String.format("%032x", new BigInteger(1, bytes));
//        }
//        catch (UnsupportedEncodingException e) {
//            throw new IllegalStateException("UTF-8 encoding not available.  Fatal (should be in the JDK).");
//        }
//    }
//}
