package edu.traning.web.controller;

import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Command {

    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
