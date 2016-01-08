package fr.isen.m2.jee.tarotspreadsheet;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createSpreadsheet")
public class CreateSpreadsheet extends HttpServlet {

    @Inject
    private Spreadsheet spreadsheet;

    public Spreadsheet getSpreadsheet() {
        return spreadsheet;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int nbPlayer = Integer.valueOf(req.getParameter("nb_player"));
        String name = req.getParameter("name_spreadsheet");
        spreadsheet = new Spreadsheet(name, nbPlayer);
        log("Number of player " + spreadsheet.getNbPlayer());
        req.getSession().setAttribute("spreadsheet", spreadsheet);
        req.getRequestDispatcher("/spreadsheet.jsp").include(req, resp);
    }


}
