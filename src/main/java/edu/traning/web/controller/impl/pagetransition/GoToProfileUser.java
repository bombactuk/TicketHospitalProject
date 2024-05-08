package edu.traning.web.controller.impl.pagetransition;

import edu.traning.web.controller.Command;
import edu.traning.web.entity.ContactsCommunications;
import edu.traning.web.entity.User;
import edu.traning.web.entity.UserInfo;
import edu.traning.web.logic.InformationLogic;
import edu.traning.web.logic.LogicException;
import edu.traning.web.logic.LogicProvider;
import edu.traning.web.logic.UserLogic;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class GoToProfileUser implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final InformationLogic logicInfo = logicProvider.getLogicContacts();
    private final UserLogic logicUser = logicProvider.getLogicUser();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            int idUser = Integer.parseInt(request.getParameter("idUser"));

            List<ContactsCommunications> contactsFooter = logicInfo.allConnectionsWithUs();
            request.setAttribute("contactsFooter", contactsFooter);

            request.setAttribute("infoUser",logicUser.informationUser(new User(idUser)));

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/user_profile.jsp");
            dispatcher.forward(request, response);

        } catch (LogicException e) {

            response.getWriter().print("Go user profile us Error");

        }

    }

}
