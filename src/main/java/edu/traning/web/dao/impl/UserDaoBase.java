package edu.traning.web.dao.impl;

import edu.traning.web.dao.DaoException;
import edu.traning.web.dao.UserDao;
import edu.traning.web.dao.impl.configuration.ConfigFilesDataBase;
import edu.traning.web.entity.User;
import edu.traning.web.entity.UserAuthorizationInfo;
import edu.traning.web.entity.UserInfo;
import edu.traning.web.entity.UserRegistrationInfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class UserDaoBase implements UserDao {

    private final ConfigFilesDataBase dataBase = ConfigFilesDataBase.getInstance();

    private static final String accountAuthorizationUser = "SELECT * FROM user_account WHERE login = ?" +
            " AND password = ?";

    @Override
    public User authorisationUser(UserAuthorizationInfo user) throws DaoException {

        ResultSet resSet;

        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareStatement(accountAuthorizationUser);

            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());

            resSet = prSt.executeQuery();

            if (resSet.next()) {

                return new User(resSet.getInt(1), resSet.getString(4), resSet.getString(7),
                        resSet.getString(8));

            } else {

                return null;

            }

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String accountAuthorizationTokenUser = "SELECT * FROM user_account WHERE token = ?";

    @Override
    public User authorisationUser(User user) throws DaoException {

        ResultSet resSet;

        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareStatement(accountAuthorizationTokenUser);

            prSt.setString(1, user.getToken());

            resSet = prSt.executeQuery();

            if (resSet.next()) {

                return new User(resSet.getInt(1), resSet.getString(4), resSet.getString(7),
                        resSet.getString(8));

            } else {

                return null;

            }

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String addTokenUser = "UPDATE user_account SET token = ? WHERE iduser_account = ?";

    @Override
    public boolean addTokenUser(User user) throws DaoException {

        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareCall(addTokenUser);

            prSt.setString(1, user.getToken());
            prSt.setInt(2, user.getId());

            prSt.executeUpdate();

            return true;

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

    private static final String accountInformationUser = "SELECT * FROM user_account WHERE iduser_account = ?";

    @Override
    public UserInfo informationUser(User user) throws DaoException {

        ResultSet resSet;

        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareStatement(accountInformationUser);

            prSt.setInt(1, user.getId());

            resSet = prSt.executeQuery();

            if (resSet.next()) {

                return new UserInfo(resSet.getString(4), resSet.getString(2),
                        LocalDate.parse(resSet.getString(5)), resSet.getString(6));

            } else {

                return null;

            }

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String accountUpdateInformationUser = "SELECT * FROM user_account WHERE iduser_account = ?";

    @Override
    public User informationUserUpdate(User user) throws DaoException {

        ResultSet resSet;

        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareStatement(accountUpdateInformationUser);

            prSt.setInt(1, user.getId());

            resSet = prSt.executeQuery();

            if (resSet.next()) {

                return new User(resSet.getInt(1), resSet.getString(4), resSet.getString(7));

            } else {

                return null;

            }

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String updateUserIntoDataBase = "UPDATE user_account SET name = ?, role = ?" +
            " WHERE iduser_account = ?";

    @Override
    public boolean updateUser(User user) throws DaoException {

        try (Connection dbConnection = dataBase.getConnection()) {

            if (user != null) {

                PreparedStatement prSt = dbConnection.prepareCall(updateUserIntoDataBase);

                prSt.setString(1, user.getName());
                prSt.setString(2, user.getRole());
                prSt.setInt(3, user.getId());

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
