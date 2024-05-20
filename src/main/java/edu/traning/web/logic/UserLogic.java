package edu.traning.web.logic;

import edu.traning.web.entity.User;
import edu.traning.web.entity.UserAuthorizationInfo;
import edu.traning.web.entity.UserInfo;
import edu.traning.web.entity.UserRegistrationInfo;

public interface UserLogic {

    User authorisationUser(UserAuthorizationInfo user) throws LogicException;

    User authorisationUser(User user) throws LogicException;

    boolean addTokenUser(User user) throws LogicException;

    boolean registrUser(UserRegistrationInfo user) throws LogicException;

    UserInfo informationUser(User user) throws LogicException;

    User informationUserUpdate(User user) throws LogicException;

    boolean updateUser(User user) throws LogicException;

}
