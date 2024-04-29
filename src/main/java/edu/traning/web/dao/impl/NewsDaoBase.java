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

}
