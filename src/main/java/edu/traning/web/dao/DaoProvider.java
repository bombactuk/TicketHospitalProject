package edu.traning.web.dao;

import edu.traning.web.dao.impl.NewsDaoBase;
import edu.traning.web.dao.impl.UserDaoBase;

public final class DaoProvider {

    private static final DaoProvider INSTANCE;

    static {
        INSTANCE = new DaoProvider();
    }

    private DaoProvider() {
    }

    private UserDao userDao = new UserDaoBase();
    private NewsDao newsDao = new NewsDaoBase();

    public UserDao getUserDao() {
        return userDao;
    }

    public NewsDao getNewsDao() {
        return newsDao;
    }

    public static DaoProvider getInstance() {
        return INSTANCE;
    }

}