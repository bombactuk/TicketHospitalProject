package edu.traning.web.controller.impl.command.user;

import edu.traning.web.controller.Command;
import edu.traning.web.entity.User;
import edu.traning.web.logic.LogicException;
import edu.traning.web.logic.LogicProvider;
import edu.traning.web.logic.UserLogic;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserUpdateCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final UserLogic logicUser = logicProvider.getLogicUser();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            User user = new User();

            user.setId(Integer.parseInt(request.getParameter("id")));
            user.setName(request.getParameter("name"));
            user.setRole(request.getParameter("role"));

            if (logicUser.updateUser(user)) {

                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Update user was successful!");

            } else {

                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Update user was not successful!");

            }


        } catch (LogicException e) {

            response.getWriter().print("<script type='text/javascript'>alert('" + "update user us Error" + "');" +
                    " window.history.back();</script>");

        }

    }

}
