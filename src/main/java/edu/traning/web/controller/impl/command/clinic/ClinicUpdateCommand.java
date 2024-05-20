package edu.traning.web.controller.impl.command.clinic;

import edu.traning.web.controller.Command;
import edu.traning.web.entity.Clinic;
import edu.traning.web.logic.ClinicLogic;
import edu.traning.web.logic.LogicException;
import edu.traning.web.logic.LogicProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ClinicUpdateCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final ClinicLogic logicClinic = logicProvider.getLogicClinic();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            Clinic clinic = new Clinic();

            clinic.setIdClinic(Integer.parseInt(request.getParameter("id")));
            clinic.setName(request.getParameter("name"));
            clinic.setCountry(request.getParameter("country"));
            clinic.setCity(request.getParameter("city"));
            clinic.setAddress(request.getParameter("address"));
            clinic.setRegistrationNumber(request.getParameter("registrationNumber"));
            clinic.setGeneralInformation(request.getParameter("generalInformation"));
            clinic.setStructure(request.getParameter("structure"));
            clinic.setSchedule(request.getParameter("schedule"));

            if (logicClinic.updateClinic(clinic)) {

                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Update clinic successful!");

            } else {

                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Update clinic was not successful!");

            }

        } catch (LogicException e) {

            response.getWriter().print("<script type='text/javascript'>alert('" + "update clinic us Error" + "');" +
                    " window.history.back();</script>");

        }

    }

}
