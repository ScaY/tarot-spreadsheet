package fr.isen.m2.jee.tarotspreadsheet.web.servlet;

import fr.isen.m2.jee.tarotspreadsheet.dao.SpreadsheetDAO;
import fr.isen.m2.jee.tarotspreadsheet.web.ServletUtil;
import fr.isen.m2.jee.tarotspreadsheet.web.Bean.SpreadsheetBean;

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

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String token = ServletUtil.getTokenFromRequest(request);
        spreadsheet.loadFromToken(token);
        request.getRequestDispatcher("/spreadsheet.jsp").include(request,
                response);
    }

}
