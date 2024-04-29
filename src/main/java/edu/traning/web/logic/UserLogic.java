package edu.traning.web.logic;

import edu.traning.web.entity.User;
import edu.traning.web.entity.UserAuthorizationInfo;
import edu.traning.web.entity.UserRegistrationInfo;

public interface UserLogic {

    User authorisationUser(UserAuthorizationInfo user) throws LogicException;

    boolean registrUser(UserRegistrationInfo user) throws LogicException;

}
