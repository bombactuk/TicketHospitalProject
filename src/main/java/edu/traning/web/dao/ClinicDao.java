package edu.traning.web.dao;

import edu.traning.web.entity.Clinic;

import java.util.List;

public interface ClinicDao {

    List<Clinic> listOutputClinic() throws DaoException;

    List<Clinic> clinicInfo(int idClinic) throws DaoException;

    List<Clinic> searchClinic(String meaning) throws DaoException;

}
