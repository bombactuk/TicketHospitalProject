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

public class FooterUpdateCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();

    private final InformationLogic logicInfo = logicProvider.getLogicContacts();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            ContactsCommunications footer = new ContactsCommunications();

            footer.setId(Integer.parseInt(request.getParameter("id")));
            footer.setImg(request.getParameter("img"));
            footer.setLink(request.getParameter("link"));

            if (logicInfo.updateFooter(footer)) {

                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Update footer was successful!");

            } else {

                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Update footer was not successful!");

            }


        } catch (LogicException e) {

            response.getWriter().print("<script type='text/javascript'>alert('" + "update footer us Error" + "');" +
                    " window.history.back();</script>");

        }

    }

}
