package edu.traning.web.logic;


import edu.traning.web.entity.AboutInfo;
import edu.traning.web.entity.ContactsCommunications;

import java.util.List;

public interface InformationLogic {

    List<ContactsCommunications> allConnectionsWithUs() throws LogicException;

    List<AboutInfo> allAboutInfo() throws LogicException;

}
