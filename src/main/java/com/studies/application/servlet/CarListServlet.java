package com.studies.application.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarListServlet extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(FindCarServlet.class);

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        logger.info("CustomServlet doGet() method is invoked");
//        req.getRequestDispatcher("/upload.jsp").forward(req, resp);
        // Set response content type
        resp.setContentType("text/html");
        super.doGet(req,resp);
//        req.getRequestDispatcher("/WEB-INF/jsp/carlist.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        logger.info("CustomServlet doPost() method is invoked");
        logger.info("carBrand po przejściu ze strony /findcar i kliknięciu submit: "+req.getParameter("carBrand"));
        List<String> carBrandlist = new ArrayList<>();
        //TODO START Na potrzeby testów dodano manualnie. Docelowo dodawanie z bazy
        carBrandlist.add("Nissan");
        carBrandlist.add("BWM");
        //TODO END
        req.setAttribute("cars",carBrandlist);
        req.getRequestDispatcher("/WEB-INF/jsp/carlist.jsp").forward(req, resp);

    }
}