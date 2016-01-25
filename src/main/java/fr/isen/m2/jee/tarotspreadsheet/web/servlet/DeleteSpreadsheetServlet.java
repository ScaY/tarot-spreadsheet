package fr.isen.m2.jee.tarotspreadsheet.web.servlet;

import fr.isen.m2.jee.tarotspreadsheet.dao.SpreadsheetDAO;
import fr.isen.m2.jee.tarotspreadsheet.web.ServletUtil;

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
@WebServlet(urlPatterns = "/deleteSpreadsheet/*")
public class DeleteSpreadsheetServlet extends HttpServlet {

    @Inject
    SpreadsheetDAO spreadsheetDAO;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String token = ServletUtil.getTokenFromRequest(request);
        spreadsheetDAO.deleteFromToken(token);
        request.getRequestDispatcher("/index.jsp").include(request,
                response);
    }
}
