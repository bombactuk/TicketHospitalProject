package edu.traning.web.controller.impl.command.information;

import edu.traning.web.controller.Command;
import edu.traning.web.entity.ContactsCommunications;
import edu.traning.web.logic.InformationLogic;
import edu.traning.web.logic.LogicException;
import edu.traning.web.logic.LogicProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class FooterAddCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();

    private final InformationLogic logicInfo = logicProvider.getLogicContacts();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            ContactsCommunications contact = new ContactsCommunications();

            contact.setImg(request.getParameter("img"));
            contact.setLink(request.getParameter("link"));

            if (logicInfo.addFooter(contact)) {
                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Addition was successful!");
            } else {
                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Adding was not successful!");
            }

        } catch (LogicException e) {

            response.getWriter().print("<script type='text/javascript'>alert('" + "addFooter Error" + "');" +
                    " window.history.back();</script>");

        }

    }

}
