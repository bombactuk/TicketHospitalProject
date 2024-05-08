package edu.traning.web.logic;

import edu.traning.web.entity.Token;

public interface EncryptionLogic {

    Token encryptionToken(Token token) throws LogicException;

    Token transcriptToken(Token token) throws LogicException;

}
