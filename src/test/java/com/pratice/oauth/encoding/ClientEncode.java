package com.pratice.oauth.encoding;

import org.apache.commons.codec.binary.Base64;

public class ClientEncode {

    public static void main(String args[]) {
//        String credentials = "testClient:testSecret";
        String credentials = "sample@test.com:1234";
        String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));
        System.out.println(encodedCredentials);
    }
}
