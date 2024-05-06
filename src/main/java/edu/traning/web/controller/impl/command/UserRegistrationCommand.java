package edu.traning.web.controller.impl.command;

import java.io.IOException;
import java.time.LocalDate;

import edu.traning.web.controller.Command;
import edu.traning.web.entity.UserRegistrationInfo;
import edu.traning.web.logic.LogicException;
import edu.traning.web.logic.LogicProvider;
import edu.traning.web.logic.UserLogic;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserRegistrationCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();

    private final UserLogic logic = logicProvider.getLogicUser();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            UserRegistrationInfo user = new UserRegistrationInfo();

            user.setLogin(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setName(request.getParameter("name"));
            user.setBirthday(LocalDate.parse(request.getParameter("dob")));
            user.setCountry(request.getParameter("country"));
            user.setRole("user");

            if (logic.registrUser(user)) {

                response.sendRedirect("urlToServlet?command=go_to_authorization&" +
                        "authMessage=Registration completed successfully!");

            } else {

                response.sendRedirect("urlToServlet?command=go_to_registration&" +
                        "regError=The login already exists!");

            }

        } catch (LogicException e) {

            response.getWriter().print("Registration Error");

        }

    }

}
