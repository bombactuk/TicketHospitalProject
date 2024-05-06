package edu.traning.web.logic;

import edu.traning.web.entity.Clinic;

import java.util.List;

public interface ClinicLogic {

    List<Clinic> listOutputClinic() throws LogicException;

    List<Clinic> clinicInfo(int idClinic) throws LogicException;

    List<Clinic> searchClinic(String meaning) throws LogicException;

}
