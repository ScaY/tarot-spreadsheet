package fr.isen.m2.jee.tarotspreadsheet.web;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by stephane on 23/01/16.
 */
public class ServletUtil {

    public static String getTokenFromRequest(HttpServletRequest request) {
        if (request == null) {
            return "";
        }

        String token = request.getRequestURI().substring(request.getContextPath().length()
                + request.getServletPath().length() + 1);

        return token;

    }
}
