package edu.traning.web.dao.impl;

import edu.traning.web.dao.ClinicDao;
import edu.traning.web.dao.DaoException;
import edu.traning.web.dao.impl.configuration.ConfigFilesDataBase;
import edu.traning.web.entity.Clinic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClinicDaoBase implements ClinicDao {

    private final ConfigFilesDataBase dataBase = ConfigFilesDataBase.getInstance();

    private static final String clinicList = "SELECT * FROM clinics_list";

    @Override
    public List<Clinic> listOutputClinic() throws DaoException {

        List<Clinic> clinics = new ArrayList<>();

        ResultSet resSet;

        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareStatement(clinicList);

            resSet = prSt.executeQuery();


            while (resSet.next()) {

                clinics.add(new Clinic(resSet.getInt(1), resSet.getString(2),
                        resSet.getString(3), resSet.getString(4),
                        resSet.getString(5)));

            }

            return clinics;

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String clinicInfo = "SELECT * FROM clinics_list WHERE idclinics_list = ?";

    @Override
    public Clinic clinicInfo(Clinic clinic) throws DaoException {

        ResultSet resSet;

        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareStatement(clinicInfo);

            prSt.setInt(1, clinic.getIdClinic());

            resSet = prSt.executeQuery();

            if (resSet.next()) {

                return new Clinic(resSet.getInt(1), resSet.getString(2),
                        resSet.getString(3), resSet.getString(4),
                        resSet.getString(5), resSet.getString(6), resSet.getString(7),
                        resSet.getString(8), resSet.getString(9));

            } else {

                return null;

            }

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String search = "SELECT * FROM clinics_list WHERE CONCAT(name, city, address, country)" +
            " LIKE CONCAT('%', ? , '%')";

    @Override
    public List<Clinic> searchClinic(String meaning) throws DaoException {

        ResultSet resSet;

        List<Clinic> clinic = new ArrayList<>();

        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareStatement(search);

            prSt.setString(1, meaning);

            resSet = prSt.executeQuery();


            while (resSet.next()) {

                clinic.add(new Clinic(resSet.getInt(1), resSet.getString(2),
                        resSet.getString(3), resSet.getString(4),
                        resSet.getString(5)));

            }

            return clinic;

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String insertClinicIntoDataBase = "INSERT INTO clinics_list" +
            " (name, country, city, address, registration_number, general_information, structure, schedule)" +
            " VALUES(?,?,?,?,?,?,?,?)";

    @Override
    public boolean addClinic(Clinic clinic) throws DaoException {

        try (Connection dbConnection = dataBase.getConnection()) {

            if (clinic != null) {

                PreparedStatement prSt = dbConnection.prepareCall(insertClinicIntoDataBase);

                prSt.setString(1, clinic.getName());
                prSt.setString(2, clinic.getCountry());
                prSt.setString(3, clinic.getCity());
                prSt.setString(4, clinic.getAddress());
                prSt.setString(5, clinic.getRegistrationNumber());
                prSt.setString(6, clinic.getGeneralInformation());
                prSt.setString(7, clinic.getStructure());
                prSt.setString(8, clinic.getSchedule());

                prSt.executeUpdate();

                return true;

            } else {

                return false;

            }

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String deleteClinicAndDoctorIntoDataBase = "DELETE clinics_list, doctors_list" +
            " FROM clinics_list" +
            " JOIN doctors_list ON clinics_list.idclinics_list = doctors_list.id_clinic" +
            " WHERE clinics_list.idclinics_list = ?";

    @Override
    public boolean deleteClinic(int idClinic) throws DaoException {

        try (Connection dbConnection = dataBase.getConnection()) {

            if (idClinic != 0) {

                PreparedStatement prSt = dbConnection.prepareCall(deleteClinicAndDoctorIntoDataBase);

                prSt.setInt(1, idClinic);

                prSt.executeUpdate();

                return true;

            } else {

                return false;

            }

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String updateNewsIntoDataBase = "UPDATE clinics_list SET name = ?, country = ?, city = ?, address = ?," +
            " registration_number = ?, general_information = ?, structure = ?, schedule = ? WHERE idclinics_list = ?";

    @Override
    public boolean updateClinic(Clinic clinic) throws DaoException {

        try (Connection dbConnection = dataBase.getConnection()) {

            if (clinic != null) {

                PreparedStatement prSt = dbConnection.prepareCall(updateNewsIntoDataBase);

                prSt.setString(1, clinic.getName());
                prSt.setString(2, clinic.getCountry());
                prSt.setString(3, clinic.getCity());
                prSt.setString(4, clinic.getAddress());
                prSt.setString(5, clinic.getRegistrationNumber());
                prSt.setString(6, clinic.getGeneralInformation());
                prSt.setString(7, clinic.getStructure());
                prSt.setString(8, clinic.getSchedule());
                prSt.setInt(9, clinic.getIdClinic());

                prSt.executeUpdate();

                return true;

            } else {

                return false;

            }

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

}

