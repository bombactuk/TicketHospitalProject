package edu.traning.web.logic;

import edu.traning.web.entity.Doctor;

import java.util.List;

public interface DoctorLogic {

    List<Doctor> listOutputDoctor() throws LogicException;

    List<Doctor> listOutputDoctor(int idClinic) throws LogicException;

    boolean addDoctor(Doctor doctor) throws LogicException;

    Doctor doctorInfo(Doctor doctor) throws LogicException;

    List<Doctor> searchDoctor(String meaning) throws LogicException;

    boolean updateDoctor(Doctor doctor) throws LogicException;

}
