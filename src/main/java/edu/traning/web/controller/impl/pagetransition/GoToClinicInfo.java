package edu.traning.web.controller.impl.pagetransition;

import edu.traning.web.controller.Command;
import edu.traning.web.entity.Clinic;
import edu.traning.web.entity.ContactsCommunications;
import edu.traning.web.logic.ClinicLogic;
import edu.traning.web.logic.InformationLogic;
import edu.traning.web.logic.LogicException;
import edu.traning.web.logic.LogicProvider;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class GoToClinicInfo implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final InformationLogic logicInfo = logicProvider.getLogicContacts();
    private final ClinicLogic logicClinic = logicProvider.getLogicClinic();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int idClinic = Integer.parseInt(request.getParameter("idClinic"));

            List<ContactsCommunications> contactsFooter = logicInfo.allConnectionsWithUs();
            request.setAttribute("contactsFooter", contactsFooter);

            List<Clinic> infoClinic = logicClinic.clinicInfo(idClinic);
            request.setAttribute("infoClinic", infoClinic);

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/clinic_info.jsp");
            dispatcher.forward(request, response);

        } catch (LogicException e) {

            response.getWriter().print("Go clinic info us Error");

        }

    }

}
