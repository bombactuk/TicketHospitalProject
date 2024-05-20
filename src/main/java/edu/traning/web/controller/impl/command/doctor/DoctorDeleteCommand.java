package edu.traning.web.controller.impl.command.doctor;

import edu.traning.web.controller.Command;
import edu.traning.web.logic.DoctorLogic;
import edu.traning.web.logic.LogicException;
import edu.traning.web.logic.LogicProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DoctorDeleteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final DoctorLogic logicDoctor = logicProvider.getLogicDortor();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            int idDoctor = Integer.parseInt(request.getParameter("idDoctor"));

            if (logicDoctor.deleteDoctor(idDoctor)) {

                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Delete was successful!");

            } else {

                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Delete was not successful!");

            }


        } catch (LogicException e) {

            response.getWriter().print("<script type='text/javascript'>alert('" + "delete doctor us Error" + "');" +
                    " window.history.back();</script>");

        }

    }

}
