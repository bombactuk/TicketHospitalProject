package edu.traning.web.dao;

import edu.traning.web.entity.News;

import java.util.List;

public interface NewsDao {

    List<News> lastNews() throws DaoException;

}
