package edu.traning.web.logic.impl;

import edu.traning.web.dao.InformationDao;
import edu.traning.web.dao.DaoException;
import edu.traning.web.dao.DaoProvider;
import edu.traning.web.entity.AboutInfo;
import edu.traning.web.entity.ContactsCommunications;
import edu.traning.web.logic.InformationLogic;
import edu.traning.web.logic.LogicException;

import java.util.List;

public class InformationLogicImpl implements InformationLogic {

    private final DaoProvider provider = DaoProvider.getInstance();
    private final InformationDao dao = provider.getContactsDao();

    @Override
    public List<ContactsCommunications> allConnectionsWithUs() throws LogicException {

        try {
            return dao.allConnectionsWithUs();
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public ContactsCommunications infoFooter(ContactsCommunications footer) throws LogicException {

        try {
            return dao.infoFooter(footer);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public AboutInfo allAboutInfo() throws LogicException {

        try {
            return dao.allAboutInfo();
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public boolean addFooter(ContactsCommunications communication) throws LogicException {

        try {
            return dao.addFooter(communication);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public boolean deleteFooter(int idFooter) throws LogicException {

        try {
            return dao.deleteFooter(idFooter);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public boolean updateAboutUs(AboutInfo aboutInfo) throws LogicException {

        try {
            return dao.updateAboutUs(aboutInfo);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public boolean updateFooter(ContactsCommunications footer) throws LogicException {

        try {
            return dao.updateFooter(footer);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

}
