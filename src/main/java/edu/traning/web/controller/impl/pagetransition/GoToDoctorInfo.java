package edu.traning.web.controller.impl.pagetransition;

import edu.traning.web.controller.Command;
import edu.traning.web.entity.Clinic;
import edu.traning.web.entity.ContactsCommunications;
import edu.traning.web.entity.Doctor;
import edu.traning.web.logic.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class GoToDoctorInfo implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final InformationLogic logicInfo = logicProvider.getLogicContacts();
    private final ClinicLogic logicClinic = logicProvider.getLogicClinic();
    private final DoctorLogic logicDoctor = logicProvider.getLogicDortor();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int idDoctor = Integer.parseInt(request.getParameter("idDoctor"));
            int idClinic = Integer.parseInt(request.getParameter("idClinic"));

            List<ContactsCommunications> contactsFooter = logicInfo.allConnectionsWithUs();
            request.setAttribute("contactsFooter", contactsFooter);

            request.setAttribute("infoDoctor", logicDoctor.doctorInfo(new Doctor(idDoctor)));

            request.setAttribute("infoClinic", logicClinic.clinicInfo(new Clinic(idClinic)));

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/doctor_info.jsp");
            dispatcher.forward(request, response);

        } catch (LogicException e) {

            response.getWriter().print("<script type='text/javascript'>alert('" + "Go doctor info us Error" + "');" +
                    " window.history.back();</script>");

        }

    }

}
