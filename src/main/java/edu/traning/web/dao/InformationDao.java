package edu.traning.web.dao;

import edu.traning.web.entity.AboutInfo;
import edu.traning.web.entity.ContactsCommunications;

import java.util.List;

public interface InformationDao {

    List<ContactsCommunications> allConnectionsWithUs() throws DaoException;

    List<AboutInfo> allAboutInfo() throws DaoException;

}
