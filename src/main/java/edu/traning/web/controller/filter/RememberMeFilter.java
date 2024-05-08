package edu.traning.web.controller.filter;

import edu.traning.web.entity.Token;
import edu.traning.web.entity.User;
import edu.traning.web.entity.UserAuthorizationInfo;
import edu.traning.web.logic.EncryptionLogic;
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
    private final EncryptionLogic logicEncryption = logicProvider.getLogicEncryption();
    private final UserLogic logicUser = logicProvider.getLogicUser();

    public RememberMeFilter() {
        super();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse) res;
        HttpServletRequest httpRequest = (HttpServletRequest) req;

        try {
            Cookie[] cookies = httpRequest.getCookies();

            for (Cookie c : cookies) {

                System.out.println("Cookie Name: " + c.getValue());

                if (c.getName().equals("remember-me")) {

                    Token transcriptToken = logicEncryption.transcriptToken(new Token(c.getValue()));

                    User user = logicUser.authorisationUser(new User(transcriptToken.getToken()));

                    if (user != null) {

                        HttpSession session = httpRequest.getSession(true);

                        session.setAttribute("userRole", user.getRole());
                        session.setAttribute("userName", user.getName());
                        session.setAttribute("userId", user.getId());

                    }

                }

            }

            chain.doFilter(req, res);

        } catch (LogicException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

}
