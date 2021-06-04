package com.studies.application.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class CustomServlet extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(CustomServlet.class);

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        logger.info("CustomServlet doGet() method is invoked");
//        req.getRequestDispatcher("/upload.jsp").forward(req, resp);
        // Set response content type
        resp.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + "abcd" + "</h1>");

    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        logger.info("CustomServlet doPost() method is invoked");
        super.doPost(req, resp);
    }
}