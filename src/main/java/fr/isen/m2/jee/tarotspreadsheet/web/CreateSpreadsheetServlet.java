package fr.isen.m2.jee.tarotspreadsheet.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createSpreadsheet")
public class CreateSpreadsheetServlet extends HttpServlet {

    private static final Log LOG = LogFactory.getLog(CreateSpreadsheetServlet.class);

    @Inject
    SpreadsheetBean spreadsheet;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log("Do get CreateSpreadsheet");
        int nbPlayer = Integer.valueOf(req.getParameter("nb_joueur"));
        String name = req.getParameter("nom_feuille");

        spreadsheet.createNewSpreadsheet();

        req.getRequestDispatcher("/spreadsheet.jsp").include(req, resp);
    }


}
