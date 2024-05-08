package edu.traning.web.logic;

import edu.traning.web.logic.impl.*;

public final class LogicProvider {

    private static final LogicProvider instance = new LogicProvider();
    private UserLogic logicUser = new UserLogicImpl();
    private NewsLogic logicNews = new NewsLogicImpl();
    private InformationLogic logicContacts = new InformationLogicImpl();
    private ClinicLogic logicClinic = new ClinicLogicImpl();
    private EncryptionLogic logicEncryption = new EncryptionLogicImpl();

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

    public EncryptionLogic getLogicEncryption() {
        return this.logicEncryption;
    }

    public static LogicProvider getInstance() {
        return instance;
    }

}
