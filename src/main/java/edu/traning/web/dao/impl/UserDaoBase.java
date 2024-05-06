package edu.traning.web.dao.impl;

import edu.traning.web.dao.DaoException;
import edu.traning.web.dao.UserDao;
import edu.traning.web.dao.impl.configuration.ConfigFilesDataBase;
import edu.traning.web.entity.User;
import edu.traning.web.entity.UserAuthorizationInfo;
import edu.traning.web.entity.UserRegistrationInfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoBase implements UserDao {

    private final ConfigFilesDataBase dataBase = ConfigFilesDataBase.getInstance();

    private static final String accountAuthorizationUser = "SELECT * FROM user_account WHERE login = ?" + " AND password = ?";

    @Override
    public User authorisationUser(UserAuthorizationInfo user) throws DaoException {

        ResultSet resSet;

        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareStatement(accountAuthorizationUser);

            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());

            resSet = prSt.executeQuery();

            if (resSet.next()) {

                return new User(resSet.getString(4),resSet.getString(7),
                        resSet.getString(2), resSet.getString(5),resSet.getString(6));

            } else {

                return null;

            }

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String accountSearchUser = "SELECT * FROM user_account WHERE login = ?";
    private static final String insertAccountUser = "INSERT INTO user_account" +
            " ( login , password, name, birthday, country,role ) VALUES(?,?,?,?,?,?)";

    @Override
    public boolean registrUser(UserRegistrationInfo user) throws DaoException {

        ResultSet resSet;

        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareStatement(accountSearchUser);

            prSt.setString(1, user.getLogin());

            resSet = prSt.executeQuery();

            if (!resSet.next()) {

                prSt = dbConnection.prepareCall(insertAccountUser);

                prSt.setString(1, user.getLogin());
                prSt.setString(2, user.getPassword());
                prSt.setString(3, user.getName());
                prSt.setString(4, user.getBirthday().toString());
                prSt.setString(5, user.getCountry());
                prSt.setString(6, user.getRole());

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
