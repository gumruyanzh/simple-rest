package com.simplerest.simplerest.rest.util;




import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;
import java.security.Key;
import java.util.Map;


public class SimpleKeyGenerator implements KeyGenerator {


    @Override
    public Key generateKey() {
        String keyString = "simplekey";
        Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
        return key;
    }
}
