package edu.traning.web.dao;

import edu.traning.web.entity.AboutInfo;
import edu.traning.web.entity.ContactsCommunications;

import java.util.List;

public interface InformationDao {

    List<ContactsCommunications> allConnectionsWithUs() throws DaoException;

    AboutInfo allAboutInfo() throws DaoException;

    boolean addFooter(ContactsCommunications communication) throws DaoException;

    boolean updateAboutUs(AboutInfo aboutInfo) throws DaoException;

    ContactsCommunications infoFooter(ContactsCommunications footer) throws DaoException;

    boolean updateFooter(ContactsCommunications footer) throws DaoException;

}
