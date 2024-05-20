package edu.traning.web.controller.impl.command.doctor;

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

public class DoctorSearchCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final InformationLogic logicInfo = logicProvider.getLogicContacts();
    private final DoctorLogic logicDoctor = logicProvider.getLogicDortor();

    private final StringBuilder meaning = new StringBuilder();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            meaning.delete(0, meaning.length());
            meaning.append(request.getParameter("query"));

            List<Doctor> doctorList;

            if (meaning.toString().isEmpty()) {

                doctorList = logicDoctor.listOutputDoctor();

            } else {

                doctorList = logicDoctor.searchDoctor(meaning.toString());

            }

            request.setAttribute("doctorsList", doctorList);

            List<ContactsCommunications> contactsFooter = logicInfo.allConnectionsWithUs();
            request.setAttribute("contactsFooter", contactsFooter);

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/doctors.jsp");
            dispatcher.forward(request, response);

        } catch (LogicException e) {

            response.getWriter().print("<script type='text/javascript'>alert('" + "search doctor us Error" + "');" +
                    " window.history.back();</script>");

        }

    }

}
