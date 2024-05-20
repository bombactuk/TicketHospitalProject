package edu.traning.web.controller.impl.command.information;

import edu.traning.web.controller.Command;
import edu.traning.web.logic.InformationLogic;
import edu.traning.web.logic.LogicException;
import edu.traning.web.logic.LogicProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class FooterDeleteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();

    private final InformationLogic logicInfo = logicProvider.getLogicContacts();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            int idFooter = Integer.parseInt(request.getParameter("idFooter"));

            if (logicInfo.deleteFooter(idFooter)) {

                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Delete was successful!");

            } else {

                response.sendRedirect("urlToServlet?command=go_to_admin_profile&" +
                        "functionError=Delete was not successful!");

            }


        } catch (LogicException e) {

            response.getWriter().print("<script type='text/javascript'>alert('" + "delete footer us Error" + "');" +
                    " window.history.back();</script>");

        }

    }

}
