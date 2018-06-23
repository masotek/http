package com.infoshareacademy.jjdd3.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/items")
public class ItemsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        List<String> cart = (List) session.getAttribute("cart");
        if (cart != null) {
            cart.forEach(s -> out.println(s));
            /*for (String item : cart) {
                resp.getWriter().println(item);
            }*/
        }
    }
}
