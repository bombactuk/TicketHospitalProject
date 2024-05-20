package edu.traning.web.controller.impl.pagetransition;

import edu.traning.web.controller.Command;
import edu.traning.web.entity.*;
import edu.traning.web.logic.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoToProfileAdmin implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final InformationLogic logicInfo = logicProvider.getLogicContacts();
    private final ClinicLogic logicClinic = logicProvider.getLogicClinic();
    private final DoctorLogic logicDoctor = logicProvider.getLogicDortor();
    private final NewsLogic logicNews = logicProvider.getLogicNews();
    private final UserLogic logicUser = logicProvider.getLogicUser();
    private final StringBuilder command = new StringBuilder();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            Map<String, Object> informationForChangingData = new HashMap<>() {
                {
                    put("updateAbout", logicInfo.allAboutInfo());

                    if (request.getParameter("id") != null) {

                        put("updateNews", logicNews.infoNews(new News(Integer.parseInt(request.getParameter("id")))));
                        put("updateClinic", logicClinic.clinicInfo(new Clinic(Integer.parseInt(request.getParameter("id")))));
                        put("updateDoctor", logicDoctor.doctorInfo(new Doctor(Integer.parseInt(request.getParameter("id")))));
                        put("updateFooter", logicInfo.infoFooter(new ContactsCommunications(Integer.parseInt(request.getParameter("id")))));
                        put("updateUser", logicUser.informationUserUpdate(new User(Integer.parseInt(request.getParameter("id")))));

                    }

                }
            };

            command.delete(0, command.length());
            command.append(request.getParameter("function"));

            List<ContactsCommunications> contactsFooter = logicInfo.allConnectionsWithUs();
            request.setAttribute("contactsFooter", contactsFooter);

            for (String key : informationForChangingData.keySet()) {

                if (key.contentEquals(command)) {

                    request.setAttribute("infoObject", informationForChangingData.get(key));

                }

            }

            request.setAttribute("functionInformation", command);

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/admin_profile.jsp");
            dispatcher.forward(request, response);

        } catch (LogicException e) {

            response.getWriter().print("<script type='text/javascript'>alert('" + "Go admin profile us Error" + "');" +
                    " window.history.back();</script>");

        }

    }

}
