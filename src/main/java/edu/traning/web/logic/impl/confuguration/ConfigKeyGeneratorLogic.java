package edu.traning.web.logic.impl.confuguration;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

public class ConfigKeyGeneratorLogic {

    private static final ConfigKeyGeneratorLogic instance;

    static {
        try {
            instance = new ConfigKeyGeneratorLogic();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private final SecretKey key;

    private ConfigKeyGeneratorLogic() throws NoSuchAlgorithmException {


        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        key = keyGen.generateKey();
    }

    public SecretKey getKey() {
        return key;
    }

    public static ConfigKeyGeneratorLogic getInstance() {
        return instance;
    }

}

