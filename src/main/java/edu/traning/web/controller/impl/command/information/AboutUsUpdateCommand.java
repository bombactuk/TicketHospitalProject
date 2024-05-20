package edu.traning.web.controller.impl.command.information;

import edu.traning.web.controller.Command;
import edu.traning.web.entity.AboutInfo;
import edu.traning.web.logic.InformationLogic;
import edu.traning.web.logic.LogicException;
import edu.traning.web.logic.LogicProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AboutUsUpdateCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();

    private final InformationLogic logicInfo = logicProvider.getLogicContacts();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            AboutInfo aboutInfo = new AboutInfo();

            aboutInfo.setText(request.getParameter("text"));

            if (logicInfo.updateAboutUs(aboutInfo)) {

                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Update about successful!");

            } else {

                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Update about was not successful!");

            }

        } catch (LogicException e) {

            response.getWriter().print("<script type='text/javascript'>alert('" + "update about us Error" + "');" +
                    " window.history.back();</script>");

        }

    }

}
