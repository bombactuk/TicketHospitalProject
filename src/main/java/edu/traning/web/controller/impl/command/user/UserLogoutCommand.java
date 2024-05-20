package edu.traning.web.controller.impl.command.user;

import edu.traning.web.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class UserLogoutCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {

            for (Cookie c : cookies) {

                if (c.getName().equals("remember-me")) {

                    Cookie cookie = new Cookie("remember-me", c.getValue());
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);

                }

            }

        }

        HttpSession session = request.getSession();

        if (session != null) {
            session.invalidate();
        }

        response.sendRedirect("urlToServlet?command=go_to_index_page");

    }

}
