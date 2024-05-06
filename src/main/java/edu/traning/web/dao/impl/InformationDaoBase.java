package edu.traning.web.dao.impl;

import edu.traning.web.dao.InformationDao;
import edu.traning.web.dao.DaoException;
import edu.traning.web.dao.impl.configuration.ConfigFilesDataBase;
import edu.traning.web.entity.AboutInfo;
import edu.traning.web.entity.ContactsCommunications;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InformationDaoBase implements InformationDao {

    private final ConfigFilesDataBase dataBase = ConfigFilesDataBase.getInstance();

    private static final String contacsList = "SELECT * FROM contacts_footer";

    @Override
    public List<ContactsCommunications> allConnectionsWithUs() throws DaoException {

        List<ContactsCommunications> contacts = new ArrayList<>();

        ResultSet resSet;

        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareStatement(contacsList);

            resSet = prSt.executeQuery();


            while (resSet.next()) {

                contacts.add(new ContactsCommunications(resSet.getString(2),
                        resSet.getString(3)));

            }

            return contacts;

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String infoAboutList = "SELECT * FROM about_information";

    @Override
    public List<AboutInfo> allAboutInfo() throws DaoException {

        List<AboutInfo> infoAbout = new ArrayList<>();

        ResultSet resSet;

        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareStatement(infoAboutList);

            resSet = prSt.executeQuery();


            while (resSet.next()) {

                infoAbout.add(new AboutInfo(resSet.getString(2),
                        resSet.getString(3)));

            }

            return infoAbout;

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

}
