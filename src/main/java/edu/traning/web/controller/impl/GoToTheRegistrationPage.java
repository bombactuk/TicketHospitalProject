package edu.traning.web.controller.impl;

import java.io.IOException;

import edu.traning.web.controller.Command;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class GoToTheRegistrationPage implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registration.jsp");

        dispatcher.forward(request, response);

    }

}
