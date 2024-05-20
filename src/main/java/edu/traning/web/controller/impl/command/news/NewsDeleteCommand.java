package edu.traning.web.controller.impl.command.news;

import edu.traning.web.controller.Command;
import edu.traning.web.logic.LogicException;
import edu.traning.web.logic.LogicProvider;
import edu.traning.web.logic.NewsLogic;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class NewsDeleteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();

    private final NewsLogic logicNews = logicProvider.getLogicNews();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            int idNews = Integer.parseInt(request.getParameter("idNews"));

            if (logicNews.deleteNews(idNews)) {

                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Delete was successful!");

            } else {

                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Delete was not successful!");

            }


        } catch (LogicException e) {

            response.getWriter().print("<script type='text/javascript'>alert('" + "delete news us Error" + "');" +
                    " window.history.back();</script>");

        }

    }

}
