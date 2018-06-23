package com.infoshareacademy.jjdd3.http;

import static java.util.stream.Collectors.joining;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        resp.addHeader("ISACourse", "JJDD3");

        PrintWriter out = resp.getWriter();

        Enumeration<String> headers = req.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headerName = headers.nextElement();
            String headerValue = req.getHeader(headerName);
            out.println(headerName + ": " + headerValue);
        }

        Enumeration<String> params = req.getParameterNames();
        while (params.hasMoreElements()) {
            String paramName = params.nextElement();
            String[] paramValues = req.getParameterValues(paramName);
            out.println(paramName + " = " + Arrays.asList(paramValues).stream().collect(joining(",")));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        //doGet(req, resp);

        PrintWriter out = resp.getWriter();

        Map<String, String[]> params = req.getParameterMap();
        params.forEach((key, value) -> {
            out.println(key + " = " + Arrays.asList(value).stream().collect(joining(",")));
        });
    }
}
