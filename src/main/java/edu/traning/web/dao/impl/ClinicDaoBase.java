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
    public List<Clinic> clinicInfo(int idClinic) throws DaoException {

        ResultSet resSet;

        List<Clinic> clinic = new ArrayList<>();


        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareStatement(clinicInfo);

            prSt.setString(1, String.valueOf(idClinic));

            resSet = prSt.executeQuery();


            while (resSet.next()) {

                clinic.add(new Clinic(resSet.getInt(1), resSet.getString(2),
                        resSet.getString(3), resSet.getString(4),
                        resSet.getString(5), resSet.getString(6), resSet.getString(7),
                        resSet.getString(8), resSet.getString(9)));

            }

            return clinic;

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String search = "SELECT * FROM clinics_list WHERE CONCAT(name, city, address, country) LIKE CONCAT('%', ? , '%')";

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

}
