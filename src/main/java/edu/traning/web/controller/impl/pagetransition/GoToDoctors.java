package edu.traning.web.controller.impl.pagetransition;

import edu.traning.web.controller.Command;
import edu.traning.web.entity.ContactsCommunications;
import edu.traning.web.entity.Doctor;
import edu.traning.web.logic.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class GoToDoctors implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final InformationLogic logicInfo = logicProvider.getLogicContacts();
    private final DoctorLogic logicDoctor = logicProvider.getLogicDortor();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            List<ContactsCommunications> contactsFooter = logicInfo.allConnectionsWithUs();
            request.setAttribute("contactsFooter", contactsFooter);

            List<Doctor> doctorsList = logicDoctor.listOutputDoctor();
            request.setAttribute("doctorsList", doctorsList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/doctors.jsp");
            dispatcher.forward(request, response);

        } catch (LogicException e) {

            response.getWriter().print("<script type='text/javascript'>alert('" + "Go doctors us Error" + "');" +
                    " window.history.back();</script>");

        }

    }

}

