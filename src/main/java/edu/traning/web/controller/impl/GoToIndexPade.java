package edu.traning.web.controller.impl;

import java.io.IOException;
import java.util.List;

import edu.traning.web.controller.Command;
import edu.traning.web.entity.ContactsCommunications;
import edu.traning.web.entity.News;

import edu.traning.web.logic.InformationLogic;
import edu.traning.web.logic.LogicException;
import edu.traning.web.logic.LogicProvider;
import edu.traning.web.logic.NewsLogic;
import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.ServletException;


public class GoToIndexPade implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();

    private final NewsLogic logic = logicProvider.getLogicNews();

    private final InformationLogic logicContact = logicProvider.getLogicContacts();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<News> mainNews = logic.lastNews();
            request.setAttribute("mainNews", mainNews);

            List<ContactsCommunications> contactsFooter = logicContact.allConnectionsWithUs();
            request.setAttribute("contactsFooter", contactsFooter);

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main_index.jsp");
            dispatcher.forward(request, response);

        } catch (LogicException e) {

            response.getWriter().print("Authorisation Error");

        }

    }

}
