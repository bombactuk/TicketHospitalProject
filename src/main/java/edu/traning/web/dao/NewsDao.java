package edu.traning.web.dao;

import edu.traning.web.entity.News;

import java.util.List;

public interface NewsDao {

    List<News> lastNews() throws DaoException;

    News infoNews(News news) throws DaoException;

    boolean addNews(News news) throws DaoException;

    boolean deleteNews(int idNews) throws DaoException;

    boolean updateNews(News news) throws DaoException;

}
