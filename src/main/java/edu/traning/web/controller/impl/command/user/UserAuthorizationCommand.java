package edu.traning.web.controller.impl.command.user;

import java.io.IOException;
import java.util.UUID;

import edu.traning.web.controller.Command;
import edu.traning.web.entity.User;
import edu.traning.web.entity.UserAuthorizationInfo;
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
    private final StringBuilder login = new StringBuilder();
    private final StringBuilder password = new StringBuilder();
    private final StringBuilder rememberMe = new StringBuilder();
    private final StringBuilder token = new StringBuilder();


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            login.delete(0, login.length());
            password.delete(0, password.length());
            rememberMe.delete(0, rememberMe.length());

            login.append(request.getParameter("login"));
            password.append(request.getParameter("password"));
            rememberMe.append(request.getParameter("remember-me"));

            if (login.toString().isEmpty() || password.toString().isEmpty() || password.length() <= 4) {

                response.sendRedirect("urlToServlet?command=go_to_authorization&authMessage=Wrong login or password!");

            } else {

                User user = logicUser.authorisationUser(new UserAuthorizationInfo(login.toString(), password.toString()));

                if (user != null) {

                    HttpSession session = request.getSession(true);

                    session.setAttribute("userRole", user.getRole());
                    session.setAttribute("userName", user.getName());
                    session.setAttribute("userId", user.getId());

                    if (rememberMe.toString().equals("remember-me")) {

                        token.delete(0, token.length());
                        token.append(UUID.randomUUID());

                        Cookie cookie = new Cookie("remember-me", token.toString());

                        cookie.setHttpOnly(true);
                        cookie.setSecure(true);

                        user.setToken(token.toString());

                        if (logicUser.addTokenUser(user)) {

                            response.addCookie(cookie);

                        }

                    }

                    response.sendRedirect("urlToServlet?command=go_to_index_page");

                } else {

                    response.sendRedirect("urlToServlet?command=go_to_authorization&authMessage=Wrong login or password!");

                }

            }


        } catch (LogicException e) {

            response.getWriter().print("<script type='text/javascript'>alert('" + "Authorisation Error" + "');" +
                    " window.history.back();</script>");

        }

    }

}
