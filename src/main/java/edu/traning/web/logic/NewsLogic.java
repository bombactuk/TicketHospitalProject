package edu.traning.web.logic;

import edu.traning.web.entity.News;

import java.util.List;

public interface NewsLogic {

    List<News> lastNews() throws LogicException;

}
