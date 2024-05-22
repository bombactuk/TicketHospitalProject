package edu.traning.web.dao;

import edu.traning.web.entity.Clinic;

import java.util.List;

public interface ClinicDao {

    List<Clinic> listOutputClinic() throws DaoException;

    Clinic clinicInfo(Clinic clinic) throws DaoException;

    List<Clinic> searchClinic(String meaning) throws DaoException;

    boolean addClinic(Clinic clinic) throws DaoException;

    boolean updateClinic(Clinic clinic) throws DaoException;

}
