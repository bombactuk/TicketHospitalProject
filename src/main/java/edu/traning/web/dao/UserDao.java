package edu.traning.web.dao;

import edu.traning.web.entity.User;
import edu.traning.web.entity.UserAuthorizationInfo;
import edu.traning.web.entity.UserInfo;
import edu.traning.web.entity.UserRegistrationInfo;

public interface UserDao {

    User authorisationUser(UserAuthorizationInfo user) throws DaoException;

    User authorisationUser(User user) throws DaoException;

    boolean registrUser(UserRegistrationInfo user) throws DaoException;

    UserInfo informationUser(User user) throws DaoException;

}
