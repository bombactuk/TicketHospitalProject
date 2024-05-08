package edu.traning.web.controller.impl.pagetransition;

import edu.traning.web.controller.Command;
import edu.traning.web.entity.ContactsCommunications;
import edu.traning.web.logic.InformationLogic;
import edu.traning.web.logic.LogicException;
import edu.traning.web.logic.LogicProvider;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class GoToProfileAdmin implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final InformationLogic logicInfo = logicProvider.getLogicContacts();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            List<ContactsCommunications> contactsFooter = logicInfo.allConnectionsWithUs();
            request.setAttribute("contactsFooter", contactsFooter);

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/admin_profile.jsp");
            dispatcher.forward(request, response);

        } catch (LogicException e) {

            response.getWriter().print("Go admin profile us Error");

        }

    }

}
