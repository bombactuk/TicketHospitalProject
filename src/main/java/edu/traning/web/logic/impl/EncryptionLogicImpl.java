package edu.traning.web.logic.impl;

import edu.traning.web.entity.Token;
import edu.traning.web.logic.EncryptionLogic;
import edu.traning.web.logic.LogicException;
import edu.traning.web.logic.impl.confuguration.ConfigKeyGeneratorLogic;

import javax.crypto.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncryptionLogicImpl implements EncryptionLogic {

    private final ConfigKeyGeneratorLogic keyGeneratorLogic = ConfigKeyGeneratorLogic.getInstance();

    @Override
    public Token encryptionToken(Token token) throws LogicException {

        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE, keyGeneratorLogic.getKey());

            byte[] encryptedBytes = cipher.doFinal(token.getToken().getBytes());

            return new Token(Base64.getEncoder().encodeToString(encryptedBytes));

        } catch (NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException |
                 InvalidKeyException e) {

            throw new LogicException(e);

        }

    }

    @Override
    public Token transcriptToken(Token token) throws LogicException {

        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            cipher.init(Cipher.DECRYPT_MODE, keyGeneratorLogic.getKey());

            byte[] encryptedBytes = cipher.doFinal(token.getToken().getBytes());

            return new Token(Base64.getEncoder().encodeToString(encryptedBytes));

        } catch (NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException |
                 InvalidKeyException e) {

            throw new LogicException(e);

        }

    }

}
