package edu.traning.web.dao.impl;

import edu.traning.web.dao.DaoException;
import edu.traning.web.dao.NewsDao;
import edu.traning.web.dao.impl.configuration.ConfigFilesDataBase;
import edu.traning.web.entity.News;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoBase implements NewsDao {

    private final ConfigFilesDataBase dataBase = ConfigFilesDataBase.getInstance();

    private static final String newsList = "SELECT * FROM news_list";

    @Override
    public List<News> lastNews() throws DaoException {

        List<News> news = new ArrayList<>();

        ResultSet resSet;

        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareStatement(newsList);

            resSet = prSt.executeQuery();


            while (resSet.next()) {

                news.add(new News(resSet.getString(2), resSet.getString(3),
                        resSet.getString(4), resSet.getString(5)));

            }

            return news;

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String accountInformationUser = "SELECT * FROM news_list WHERE idnews_list = ?";

    @Override
    public News infoNews(News news) throws DaoException {

        ResultSet resSet;

        try (Connection dbConnection = dataBase.getConnection()) {

            PreparedStatement prSt = dbConnection.prepareStatement(accountInformationUser);

            prSt.setInt(1, news.getId());

            resSet = prSt.executeQuery();

            if (resSet.next()) {

                return new News(resSet.getInt(1), resSet.getString(2), resSet.getString(3),
                        resSet.getString(4), resSet.getString(5));

            } else {

                return null;

            }

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String insertNewsIntoDataBase = "INSERT INTO news_list" +
            " (title, brief, img, link) VALUES(?,?,?,?)";

    @Override
    public boolean addNews(News news) throws DaoException {

        try (Connection dbConnection = dataBase.getConnection()) {

            if (news != null) {

                PreparedStatement prSt = dbConnection.prepareCall(insertNewsIntoDataBase);

                prSt.setString(1, news.getTitle());
                prSt.setString(2, news.getBrief());
                prSt.setString(3, news.getImg());
                prSt.setString(4, news.getLink());

                prSt.executeUpdate();

                return true;

            } else {

                return false;

            }

        } catch (IOException | SQLException e) {

            System.out.println(e);

            throw new DaoException(e);

        }

    }

    private static final String deleteNewsIntoDataBase = "DELETE FROM news_list WHERE idnews_list = ?";

    @Override
    public boolean deleteNews(int idNews) throws DaoException {

        try (Connection dbConnection = dataBase.getConnection()) {

            if (idNews != 0) {

                PreparedStatement prSt = dbConnection.prepareCall(deleteNewsIntoDataBase);

                prSt.setInt(1, idNews);

                prSt.executeUpdate();

                return true;

            } else {

                return false;

            }

        } catch (IOException | SQLException e) {

            throw new DaoException(e);

        }

    }

    private static final String updateNewsIntoDataBase = "UPDATE news_list SET title = ?, brief = ?, img = ?, link = ? " +
            "WHERE idnews_list = ?";

    @Override
    public boolean updateNews(News news) throws DaoException {

        try (Connection dbConnection = dataBase.getConnection()) {

            if (news != null) {

                PreparedStatement prSt = dbConnection.prepareCall(updateNewsIntoDataBase);

                prSt.setString(1, news.getTitle());
                prSt.setString(2, news.getBrief());
                prSt.setString(3, news.getImg());
                prSt.setString(4, news.getLink());
                prSt.setInt(5, news.getId());

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

