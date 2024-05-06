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
    public List<Clinic> clinicInfo(int idClinic) throws LogicException {

        try {
            return dao.clinicInfo(idClinic);
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

}
