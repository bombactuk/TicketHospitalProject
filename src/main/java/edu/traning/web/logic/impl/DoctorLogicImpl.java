package edu.traning.web.logic.impl;

import edu.traning.web.dao.DaoException;
import edu.traning.web.dao.DaoProvider;
import edu.traning.web.dao.DoctorDao;
import edu.traning.web.entity.Doctor;
import edu.traning.web.logic.DoctorLogic;
import edu.traning.web.logic.LogicException;

import java.util.List;

public class DoctorLogicImpl implements DoctorLogic {

    private final DaoProvider provider = DaoProvider.getInstance();
    private final DoctorDao dao = provider.getDoctorDao();

    @Override
    public List<Doctor> listOutputDoctor() throws LogicException {

        try {
            return dao.listOutputDoctor();
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public List<Doctor> listOutputDoctor(int idClinic) throws LogicException {

        try {
            return dao.listOutputDoctor(idClinic);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public boolean addDoctor(Doctor doctor) throws LogicException {

        try {
            return dao.addDoctor(doctor);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public Doctor doctorInfo(Doctor doctor) throws LogicException {

        try {
            return dao.doctorInfo(doctor);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public List<Doctor> searchDoctor(String meaning) throws LogicException {

        try {
            return dao.searchDoctor(meaning);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public boolean deleteDoctor(int idDoctor) throws LogicException {

        try {
            return dao.deleteDoctor(idDoctor);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public boolean updateDoctor(Doctor doctor) throws LogicException {

        try {
            return dao.updateDoctor(doctor);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

}
