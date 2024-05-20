package edu.traning.web.logic.impl;

import edu.traning.web.dao.ClinicDao;
import edu.traning.web.dao.DaoException;
import edu.traning.web.dao.DaoProvider;
import edu.traning.web.entity.Clinic;
import edu.traning.web.logic.ClinicLogic;
import edu.traning.web.logic.LogicException;

import java.util.List;

public class ClinicLogicImpl implements ClinicLogic {

    private final DaoProvider provider = DaoProvider.getInstance();
    private final ClinicDao dao = provider.getClincDao();

    @Override
    public List<Clinic> listOutputClinic() throws LogicException {

        try {
            return dao.listOutputClinic();
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public Clinic clinicInfo(Clinic clinic) throws LogicException {

        try {
            return dao.clinicInfo(clinic);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public List<Clinic> searchClinic(String meaning) throws LogicException {

        try {
            return dao.searchClinic(meaning);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public boolean addClinic(Clinic clinic) throws LogicException {

        try {
            return dao.addClinic(clinic);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public boolean deleteClinic(int idClinic) throws LogicException {

        try {
            return dao.deleteClinic(idClinic);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public boolean updateClinic(Clinic clinic) throws LogicException {

        try {
            return dao.updateClinic(clinic);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

}
