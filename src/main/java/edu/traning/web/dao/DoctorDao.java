package edu.traning.web.dao;

import edu.traning.web.entity.Doctor;

import java.util.List;

public interface DoctorDao {

    List<Doctor> listOutputDoctor() throws DaoException;

    List<Doctor> listOutputDoctor(int idClinic) throws DaoException;

    boolean addDoctor(Doctor doctor) throws DaoException;

    Doctor doctorInfo(Doctor doctor) throws DaoException;

    List<Doctor> searchDoctor(String meaning) throws DaoException;

    boolean updateDoctor(Doctor doctor) throws DaoException;

}
