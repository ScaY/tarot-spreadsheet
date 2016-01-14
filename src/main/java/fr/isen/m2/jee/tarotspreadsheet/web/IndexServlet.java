package fr.isen.m2.jee.tarotspreadsheet.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SpreadsheetBean> spreadsheetBeanList = new LinkedList<SpreadsheetBean>();
        spreadsheetBeanList.add(new SpreadsheetBean("hello", 5));
        spreadsheetBeanList.add(new SpreadsheetBean("hello1", 5));
        spreadsheetBeanList.add(new SpreadsheetBean("hello2", 5));
        req.getSession().setAttribute("listSpreadsheet", spreadsheetBeanList);
        log("List spreadsheet retrieved");
        req.getRequestDispatcher("/index.jsp").include(req, resp);
    }
}
