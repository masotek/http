package com.infoshareacademy.jjdd3.http;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/action")
public class ActionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String cmd = req.getParameter("cmd");
        if (cmd == null) {
            resp.setStatus(400);
        } else if (cmd.equals("ok")) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else if (cmd.equals("moved")) {
            resp.setStatus(301);
        } else if (cmd.equals("auth")) {
            resp.setStatus(403);
        } else {
            resp.setStatus(400);
        }
    }
}
