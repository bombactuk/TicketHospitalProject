package edu.traning.web.logic;

import edu.traning.web.logic.impl.ClinicLogicImpl;
import edu.traning.web.logic.impl.InformationLogicImpl;
import edu.traning.web.logic.impl.NewsLogicImpl;
import edu.traning.web.logic.impl.UserLogicImpl;

public final class LogicProvider {

    private static final LogicProvider instance = new LogicProvider();
    private UserLogic logicUser = new UserLogicImpl();
    private NewsLogic logicNews = new NewsLogicImpl();
    private InformationLogic logicContacts = new InformationLogicImpl();
    private ClinicLogic logicClinic = new ClinicLogicImpl();

    private LogicProvider() {
    }

    public UserLogic getLogicUser() {
        return this.logicUser;
    }

    public NewsLogic getLogicNews() {
        return this.logicNews;
    }

    public InformationLogic getLogicContacts() {
        return this.logicContacts;
    }

    public ClinicLogic getLogicClinic() {
        return this.logicClinic;
    }

    public static LogicProvider getInstance() {
        return instance;
    }

}
