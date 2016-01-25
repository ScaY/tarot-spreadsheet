package fr.isen.m2.jee.tarotspreadsheet.web.servlet;

import fr.isen.m2.jee.tarotspreadsheet.web.Bean.SpreadsheetBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/createSpreadsheet")
public class CreateSpreadsheetServlet extends HttpServlet {

    @Inject
    SpreadsheetBean spreadsheet;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int nbPlayer = Integer.valueOf(req.getParameter("nb_joueur"));
        String name = req.getParameter("nom_feuille");
        // Create the spreadsheet and add the player
        spreadsheet.createNewSpreadsheet(name);
        for (int i = 0; i < nbPlayer; i++) {
            spreadsheet.getSpreadsheetAdapter().addPlayer("player" + i);
        }
        //req.getSession().setAttribute("spreadsheetBean", spreadsheet);
        resp.sendRedirect(req.getContextPath()
                + req.getServletPath().replace("createSpreadsheet", "") + "s/" + spreadsheet.getToken());
    }

}
