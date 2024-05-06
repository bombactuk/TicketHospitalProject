package edu.traning.web.logic.impl;

import edu.traning.web.dao.DaoException;
import edu.traning.web.dao.DaoProvider;
import edu.traning.web.dao.NewsDao;
import edu.traning.web.dao.UserDao;
import edu.traning.web.entity.News;
import edu.traning.web.logic.LogicException;
import edu.traning.web.logic.NewsLogic;

import java.util.List;

public class NewsLogicImpl implements NewsLogic {

    private final DaoProvider provider = DaoProvider.getInstance();
    private final NewsDao dao = provider.getNewsDao();

    @Override
    public List<News> lastNews() throws LogicException {

        try {
            return dao.lastNews();
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

}
