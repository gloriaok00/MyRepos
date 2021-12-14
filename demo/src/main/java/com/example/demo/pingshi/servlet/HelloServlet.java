package com.example.demo.pingshi.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet
{
    private String msg;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        msg = req.getParameter("msg");
        try
        {
            Thread.sleep(1000);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        resp.getWriter().println(msg);
    }
}
