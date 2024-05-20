package edu.traning.web.controller.impl.command.news;

import edu.traning.web.controller.Command;
import edu.traning.web.entity.News;
import edu.traning.web.logic.LogicException;
import edu.traning.web.logic.LogicProvider;
import edu.traning.web.logic.NewsLogic;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class NewsAddCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();

    private final NewsLogic logicNews = logicProvider.getLogicNews();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            News news = new News();

            news.setTitle(request.getParameter("title"));
            news.setBrief(request.getParameter("brief"));
            news.setImg(request.getParameter("img"));
            news.setLink(request.getParameter("link"));

            if (logicNews.addNews(news)) {

                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Addition was successful!");

            } else {

                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Adding was not successful!");

            }

        } catch (LogicException e) {

            response.getWriter().print("<script type='text/javascript'>alert('" + "addNews Error" + "');" +
                    " window.history.back();</script>");

        }

    }

}
