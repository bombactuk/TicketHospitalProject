package edu.traning.web.logic.impl;

import edu.traning.web.dao.DaoException;
import edu.traning.web.dao.DaoProvider;
import edu.traning.web.dao.UserDao;
import edu.traning.web.entity.User;
import edu.traning.web.entity.UserAuthorizationInfo;
import edu.traning.web.entity.UserInfo;
import edu.traning.web.entity.UserRegistrationInfo;
import edu.traning.web.logic.LogicException;
import edu.traning.web.logic.UserLogic;

public class UserLogicImpl implements UserLogic {

    private final DaoProvider provider = DaoProvider.getInstance();
    private final UserDao dao = provider.getUserDao();

    @Override
    public User authorisationUser(UserAuthorizationInfo user) throws LogicException {

        try {
            return dao.authorisationUser(user);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public User authorisationUser(User user) throws LogicException {

        try {
            return dao.authorisationUser(user);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public boolean addTokenUser(User user) throws LogicException {

        try {
            return dao.addTokenUser(user);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public boolean registrUser(UserRegistrationInfo user) throws LogicException {

        try {
            return dao.registrUser(user);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public UserInfo informationUser(User user) throws LogicException {

        try {
            return dao.informationUser(user);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public User informationUserUpdate(User user) throws LogicException {

        try {
            return dao.informationUserUpdate(user);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public boolean updateUser(User user) throws LogicException {

        try {
            return dao.updateUser(user);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

}
