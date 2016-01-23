package fr.isen.m2.jee.tarotspreadsheet.web;

import fr.isen.m2.jee.tarotspreadsheet.dao.SpreadsheetDAO;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by stephane on 23/01/16.
 */
@WebServlet(urlPatterns = "/s/*")
public class SpreadsheetServlet extends HttpServlet {

    @Inject
    SpreadsheetBean spreadsheet;

    @Inject
    SpreadsheetDAO spreadsheetDAO;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String token = getTokenFromRequest(request);
        spreadsheet.loadFromToken(token);
        request.getRequestDispatcher("/spreadsheet.jsp").include(request,
                response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        if (request == null) {
            return "";
        }

        String token = request.getRequestURI().substring(request.getContextPath().length()
                + request.getServletPath().length() + 1);

        return token;

    }
}
