package com.infoshareacademy.jjdd3.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/counter")
public class CounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        List<Cookie> cookies = Arrays.asList(req.getCookies() != null ? req.getCookies() : new Cookie[] {});
        Optional<Cookie> counterOpt = cookies.stream()
            .filter(c -> c.getName().equals("licznik")).findFirst();

        Cookie cookie = counterOpt.orElse(new Cookie("licznik", String.valueOf(0)));

//        if (counterOpt.isPresent()) {
//            cookie = counterOpt.get();
//        } else {
//            cookie = new Cookie("licznik", String.valueOf(0));
//        }

        int prevValue = Integer.valueOf(cookie.getValue());
        int newValue = prevValue + 1;
        cookie.setValue(String.valueOf(newValue));

        resp.addCookie(cookie);

        resp.getWriter().println("Number of visits: " + newValue);
    }
}
