package edu.traning.web.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

import java.io.IOException;

@WebFilter(urlPatterns = {"/urlToServlet"})

public class CharacterEncodingFilter extends HttpFilter implements Filter {

    public CharacterEncodingFilter() {
        super();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");

        chain.doFilter(req, res);

    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

}
