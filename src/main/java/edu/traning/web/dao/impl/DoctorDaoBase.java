package edu.traning.web.dao.impl;

import edu.traning.web.dao.DaoException;
import edu.traning.web.dao.DoctorDao;
import edu.traning.web.dao.impl.configuration.ConfigFilesDataBase;
import edu.traning.web.entity.Doctor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoBase implements DoctorDao {

    private final ConfigFilesDataBase dataBase = ConfigFilesDataBase.getInstance();

    private static final String doctorList = "SELECT * FROM doctors_list";

    @Override
    public List<Doctor> listOutputDoctor() throws DaoException {

        List<Doctor> doctors = new ArrayList<>();

        ResultSet resSet;

        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareStatement(doctorList);

            resSet = prSt.executeQuery();


            while (resSet.next()) {

                doctors.add(new Doctor(resSet.getInt(1), resSet.getInt(2),
                        resSet.getString(3), resSet.getString(4), resSet.getString(5)));

            }

            return doctors;

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String doctorIdClinicList = "SELECT * FROM doctors_list WHERE id_clinic = ?";

    @Override
    public List<Doctor> listOutputDoctor(int idClinic) throws DaoException {

        ResultSet resSet;

        List<Doctor> doctor = new ArrayList<>();


        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareStatement(doctorIdClinicList);

            prSt.setString(1, String.valueOf(idClinic));

            resSet = prSt.executeQuery();


            while (resSet.next()) {

                doctor.add(new Doctor(resSet.getInt(1), resSet.getInt(2),
                        resSet.getString(3), resSet.getString(4),
                        resSet.getString(5)));

            }

            return doctor;

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String insertDoctorIntoDataBase = "INSERT INTO doctors_list" +
            " (id_clinic, fio, profession, description)" +
            " VALUES(?,?,?,?)";

    @Override
    public boolean addDoctor(Doctor doctor) throws DaoException {
        try (Connection dbConnection = dataBase.getConnection()) {

            if (doctor != null) {

                PreparedStatement prSt = dbConnection.prepareCall(insertDoctorIntoDataBase);

                prSt.setInt(1, doctor.getIdClinic());
                prSt.setString(2, doctor.getFio());
                prSt.setString(3, doctor.getProfession());
                prSt.setString(4, doctor.getDescription());

                prSt.executeUpdate();

                return true;

            } else {

                return false;

            }

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String doctorInfo = "SELECT * FROM doctors_list WHERE iddoctors_list = ?";

    @Override
    public Doctor doctorInfo(Doctor doctor) throws DaoException {

        ResultSet resSet;

        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareStatement(doctorInfo);

            prSt.setInt(1, doctor.getIdDoctor());

            resSet = prSt.executeQuery();

            if (resSet.next()) {

                return new Doctor(resSet.getInt(1), resSet.getInt(2),
                        resSet.getString(3), resSet.getString(4),
                        resSet.getString(5));

            } else {

                return null;

            }

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String search = "SELECT * FROM doctors_list WHERE CONCAT(fio, profession, description)" +
            " LIKE CONCAT('%', ? , '%')";

    @Override
    public List<Doctor> searchDoctor(String meaning) throws DaoException {

        ResultSet resSet;

        List<Doctor> doctor = new ArrayList<>();

        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareStatement(search);

            prSt.setString(1, meaning);

            resSet = prSt.executeQuery();


            while (resSet.next()) {

                doctor.add(new Doctor(resSet.getInt(1), resSet.getInt(2),
                        resSet.getString(3), resSet.getString(4),
                        resSet.getString(5)));

            }

            return doctor;

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String deleteDoctorIntoDataBase = "DELETE FROM doctors_list WHERE iddoctors_list = ?";

    @Override
    public boolean deleteDoctor(int idDoctor) throws DaoException {

        try (Connection dbConnection = dataBase.getConnection()) {

            if (idDoctor != 0) {

                PreparedStatement prSt = dbConnection.prepareCall(deleteDoctorIntoDataBase);

                prSt.setInt(1, idDoctor);

                prSt.executeUpdate();

                return true;

            } else {

                return false;

            }

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String updateDoctorIntoDataBase = "UPDATE doctors_list SET id_clinic = ?, fio = ?, " +
            "profession = ?, description = ? WHERE iddoctors_list = ?";

    @Override
    public boolean updateDoctor(Doctor doctor) throws DaoException {

        try (Connection dbConnection = dataBase.getConnection()) {

            if (doctor != null) {

                PreparedStatement prSt = dbConnection.prepareCall(updateDoctorIntoDataBase);

                prSt.setInt(1, doctor.getIdClinic());
                prSt.setString(2, doctor.getFio());
                prSt.setString(3, doctor.getProfession());
                prSt.setString(4, doctor.getDescription());
                prSt.setInt(5, doctor.getIdDoctor());

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
