package edu.traning.web.controller.impl.command;

import java.io.IOException;
import java.net.URLEncoder;

import edu.traning.web.controller.Command;
import edu.traning.web.entity.Token;
import edu.traning.web.entity.User;
import edu.traning.web.entity.UserAuthorizationInfo;
import edu.traning.web.logic.EncryptionLogic;
import edu.traning.web.logic.LogicException;
import edu.traning.web.logic.LogicProvider;
import edu.traning.web.logic.UserLogic;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserAuthorizationCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final UserLogic logicUser = logicProvider.getLogicUser();
    private final EncryptionLogic logicEncryption = logicProvider.getLogicEncryption();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String rememberMe = request.getParameter("remember-me");

            User user = logicUser.authorisationUser(new UserAuthorizationInfo(login, password));

            if (user != null) {

                HttpSession session = request.getSession(true);

                session.setAttribute("userRole", user.getRole());
                session.setAttribute("userName", user.getName());
                session.setAttribute("userId", user.getId());

                if (rememberMe != null) {

                    Token encryptedToken = logicEncryption.encryptionToken(new Token(user.getToken()));

                    Cookie cookie = new Cookie("remember-me", encryptedToken.getToken());

                    response.addCookie(cookie);

                }

                response.sendRedirect("urlToServlet?command=go_to_index_page");

            } else {

                response.sendRedirect("urlToServlet?command=go_to_authorization&authMessage=Wrong login or password!");

            }

        } catch (LogicException e) {

            response.getWriter().print("Authorisation Error");

        }

    }

}
