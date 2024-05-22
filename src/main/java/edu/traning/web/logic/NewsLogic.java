package edu.traning.web.logic;

import edu.traning.web.entity.News;

import java.util.List;

public interface NewsLogic {

    List<News> lastNews() throws LogicException;

    News infoNews(News news) throws LogicException;

    boolean addNews(News news) throws LogicException;

    boolean updateNews(News news) throws LogicException;

}
