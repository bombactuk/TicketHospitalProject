package edu.traning.web.controller.filter;

import edu.traning.web.entity.User;
import edu.traning.web.logic.LogicException;
import edu.traning.web.logic.LogicProvider;
import edu.traning.web.logic.UserLogic;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebFilter(urlPatterns = {"/urlToServlet"})

public class RememberMeFilter extends HttpFilter implements Filter {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final UserLogic logicUser = logicProvider.getLogicUser();

    public RememberMeFilter() {
        super();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        try {
            HttpSession session = request.getSession(false);

            if (session == null) {

                Cookie[] cookies = request.getCookies();

                if (cookies != null) {

                    for (Cookie c : cookies) {

                        if (c.getName().equals("remember-me")) {

                            User user = logicUser.authorisationUser(new User(c.getValue()));

                            if (user != null) {

                                session.setAttribute("userRole", user.getRole());
                                session.setAttribute("userName", user.getName());
                                session.setAttribute("userId", user.getId());

                            }

                        }

                    }

                }

            }

            chain.doFilter(req, res);

        } catch (LogicException e) {

            response.sendRedirect("urlToServlet?command=go_to_index_page");

        }

    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

}
