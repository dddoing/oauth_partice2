package com.pratice.oauth.event;

import com.pratice.oauth.entity.Code;
import com.pratice.oauth.repo.CodeJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.util.SerializationUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;

public class CustomCodeService extends RandomValueAuthorizationCodeServices {

    @Autowired
    CodeJpaRepo codeJpaRepo;

    @Override
    protected void store(String code, OAuth2Authentication authentication) {
        //

        byte[] foo = SerializationUtils.serialize(authentication);
        Code saveCode = new Code(foo,code);
        codeJpaRepo.save(saveCode);
        //1. select
        // 1.1
        // 1.2
    }

    @Override
    protected OAuth2Authentication remove(String code) {
        //

        //1 select
        // 1.1 delete
        // 1.2 return null
        return null;
    }
}
