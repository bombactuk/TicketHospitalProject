package edu.traning.web.controller.impl.command.clinic;

import edu.traning.web.controller.Command;
import edu.traning.web.logic.ClinicLogic;
import edu.traning.web.logic.LogicException;
import edu.traning.web.logic.LogicProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ClinicDeleteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final ClinicLogic logicClinic = logicProvider.getLogicClinic();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            int idClinic = Integer.parseInt(request.getParameter("idClinic"));

            if (logicClinic.deleteClinic(idClinic)) {

                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Delete was successful!");

            } else {

                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Delete was not successful!");

            }


        } catch (LogicException e) {

            response.getWriter().print("<script type='text/javascript'>alert('" + "delete clinic us Error" + "');" +
                    " window.history.back();</script>");

        }

    }

}
