package edu.traning.web.controller.impl;

import java.io.IOException;

import edu.traning.web.controller.Command;
import edu.traning.web.entity.User;
import edu.traning.web.entity.UserAuthorizationInfo;
import edu.traning.web.logic.LogicException;
import edu.traning.web.logic.LogicProvider;
import edu.traning.web.logic.UserLogic;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserAuthorizationCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();

    private final UserLogic logic = logicProvider.getLogicUser();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            System.out.println("Perform user authentication and authorization. Login: " + login);

            User user = logic.authorisationUser(new UserAuthorizationInfo(login, password));

            if (user != null) {

                HttpSession session = (HttpSession) request.getSession(true);
                session.setAttribute("user", user);

                response.sendRedirect("urlToServlet?command=go_to_main_page");

            } else {

                response.sendRedirect("urlToServlet?command=go_to_authorization&authMessage=Wrong login or password!");

            }

        } catch (LogicException e) {
            response.getWriter().print("Authorisation Error");
        }


    }

}
