package edu.traning.web.controller.impl.doctor;

import edu.traning.web.controller.Command;
import edu.traning.web.entity.Doctor;
import edu.traning.web.logic.DoctorLogic;
import edu.traning.web.logic.LogicException;
import edu.traning.web.logic.LogicProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DoctorAddCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final DoctorLogic logicDoctor = logicProvider.getLogicDortor();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            Doctor doctor = new Doctor();

            doctor.setIdClinic(Integer.parseInt(request.getParameter("idClinic")));
            doctor.setFio(request.getParameter("fio"));
            doctor.setProfession(request.getParameter("profession"));
            doctor.setDescription(request.getParameter("description"));

            if (logicDoctor.addDoctor(doctor)) {

                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Addition was successful!");

            } else {

                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Adding was not successful!");

            }

        } catch (LogicException e) {

            response.getWriter().print("<script type='text/javascript'>alert('" + "add Doctor Error" + "');" +
                    " window.history.back();</script>");

        }

    }

}
