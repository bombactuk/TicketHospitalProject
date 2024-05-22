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

    private static final String contactsList = "SELECT * FROM contacts_footer";

    @Override
    public List<ContactsCommunications> allConnectionsWithUs() throws DaoException {

        List<ContactsCommunications> contacts = new ArrayList<>();

        ResultSet resSet;

        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareStatement(contactsList);

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
    public AboutInfo allAboutInfo() throws DaoException {

        ResultSet resSet;

        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareStatement(infoAboutList);

            resSet = prSt.executeQuery();


            if (resSet.next()) {

                return new AboutInfo(resSet.getString(2),
                        resSet.getString(3));

            } else {

                return null;

            }

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String insertFooterIntoDataBase = "INSERT INTO contacts_footer" +
            " (img_contacts, link_contacts)" +
            " VALUES(?,?)";

    @Override
    public boolean addFooter(ContactsCommunications communication) throws DaoException {

        try (Connection dbConnection = dataBase.getConnection()) {

            if (communication != null) {

                PreparedStatement prSt = dbConnection.prepareCall(insertFooterIntoDataBase);

                prSt.setString(1, communication.getImg());
                prSt.setString(2, communication.getLink());

                prSt.executeUpdate();

                return true;

            } else {

                return false;

            }

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String updateAboutUsIntoDataBase = "UPDATE about_information SET text = ? " +
            "WHERE idabout_information = 1";

    @Override
    public boolean updateAboutUs(AboutInfo aboutInfo) throws DaoException {

        try (Connection dbConnection = dataBase.getConnection()) {

            if (aboutInfo != null) {

                PreparedStatement prSt = dbConnection.prepareCall(updateAboutUsIntoDataBase);

                prSt.setString(1, aboutInfo.getText());

                prSt.executeUpdate();

                return true;

            } else {

                return false;

            }

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String FooterInfo = "SELECT * FROM contacts_footer WHERE idcontacts_footer = ?";

    @Override
    public ContactsCommunications infoFooter(ContactsCommunications footer) throws DaoException {

        ResultSet resSet;

        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareStatement(FooterInfo);

            prSt.setInt(1, footer.getId());

            resSet = prSt.executeQuery();

            if (resSet.next()) {

                return new ContactsCommunications(resSet.getInt(1), resSet.getString(2),
                        resSet.getString(3));

            } else {

                return null;

            }

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String updateFooterIntoDataBase = "UPDATE contacts_footer SET img_contacts = ?, " +
            "link_contacts = ? WHERE idcontacts_footer = ?";

    @Override
    public boolean updateFooter(ContactsCommunications footer) throws DaoException {

        try (Connection dbConnection = dataBase.getConnection()) {

            if (footer != null) {

                PreparedStatement prSt = dbConnection.prepareCall(updateFooterIntoDataBase);

                prSt.setString(1, footer.getImg());
                prSt.setString(2, footer.getLink());
                prSt.setInt(3, footer.getId());

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
