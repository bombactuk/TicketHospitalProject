package edu.traning.web.logic;

import edu.traning.web.entity.Clinic;

import java.util.List;

public interface ClinicLogic {

    List<Clinic> listOutputClinic() throws LogicException;

    Clinic clinicInfo(Clinic clinic) throws LogicException;

    List<Clinic> searchClinic(String meaning) throws LogicException;

    boolean addClinic(Clinic clinic) throws LogicException;

    boolean updateClinic(Clinic clinic) throws LogicException;

}
