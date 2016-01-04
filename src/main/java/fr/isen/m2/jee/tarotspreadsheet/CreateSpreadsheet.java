package fr.isen.m2.jee.tarotspreadsheet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createSpreadsheet")

public class CreateSpreadsheet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("name", "name");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("spreadsheet.jsp");
        System.out.println("requestDispatcher "+requestDispatcher);
        requestDispatcher.forward(req, resp);
    }

}
