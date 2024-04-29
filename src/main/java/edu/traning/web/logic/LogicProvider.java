package edu.traning.web.logic;

import edu.traning.web.logic.impl.NewsLogicImpl;
import edu.traning.web.logic.impl.TicketHospitalLogicImpl;
import edu.traning.web.logic.impl.UserLogicImpl;

public final class LogicProvider {

    private static final LogicProvider instance = new LogicProvider();
    private TicketHospitalLogic logicTicketHospital = new TicketHospitalLogicImpl();
    private UserLogic logicUser = new UserLogicImpl();
    private NewsLogic logicNews = new NewsLogicImpl();

    private LogicProvider() {
    }

    public TicketHospitalLogic getHospitallogic() {
        return this.logicTicketHospital;
    }

    public UserLogic getLogicUser() {
        return this.logicUser;
    }

    public NewsLogic getLogicNews() {
        return this.logicNews;
    }

    public static LogicProvider getInstance() {
        return instance;
    }

}
