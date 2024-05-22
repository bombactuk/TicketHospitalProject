package edu.traning.web.logic;


import edu.traning.web.entity.AboutInfo;
import edu.traning.web.entity.ContactsCommunications;

import java.util.List;

public interface InformationLogic {

    List<ContactsCommunications> allConnectionsWithUs() throws LogicException;

    ContactsCommunications infoFooter(ContactsCommunications footer) throws LogicException;

    AboutInfo allAboutInfo() throws LogicException;

    boolean addFooter(ContactsCommunications communication) throws LogicException;

    boolean updateAboutUs(AboutInfo aboutInfo) throws LogicException;

    boolean updateFooter(ContactsCommunications footer) throws LogicException;

}
