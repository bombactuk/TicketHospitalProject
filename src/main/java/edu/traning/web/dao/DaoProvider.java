package edu.traning.web.dao;

import edu.traning.web.dao.impl.*;

public final class DaoProvider {

    private static final DaoProvider INSTANCE;

    static {
        INSTANCE = new DaoProvider();
    }

    private DaoProvider() {
    }

    private UserDao userDao = new UserDaoBase();
    private NewsDao newsDao = new NewsDaoBase();
    private InformationDao contactsDao = new InformationDaoBase();
    private ClinicDao clincDao = new ClinicDaoBase();
    private DoctorDao doctorDao = new DoctorDaoBase();

    public UserDao getUserDao() {
        return userDao;
    }

    public NewsDao getNewsDao() {
        return newsDao;
    }

    public ClinicDao getClincDao() {
        return clincDao;
    }

    public InformationDao getContactsDao() {
        return contactsDao;
    }

    public DoctorDao getDoctorDao() {
        return doctorDao;
    }

    public static DaoProvider getInstance() {
        return INSTANCE;
    }

}