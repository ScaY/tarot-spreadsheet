package fr.isen.m2.jee.tarotspreadsheet.web;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createSpreadsheet")
public class CreateSpreadsheetServlet extends HttpServlet {

    @Inject
    private SpreadsheetBean spreadsheet;

    public SpreadsheetBean getSpreadsheet() {
        return spreadsheet;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int nbPlayer = Integer.valueOf(req.getParameter("nb_joueur"));
        String name = req.getParameter("nom_feuille");
        spreadsheet = new SpreadsheetBean(name, nbPlayer);
        log("Number of player " + spreadsheet.getNbPlayer());
        req.getSession().setAttribute("spreadsheet", spreadsheet);
        req.getRequestDispatcher("/spreadsheet.jsp").include(req, resp);
    }


}
