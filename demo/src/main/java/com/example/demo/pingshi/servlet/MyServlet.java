package com.example.demo.pingshi.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description Servlet实践
 * @date 2021-11-08 10:40
 */

@WebServlet(urlPatterns = "/ssaa",initParams = {
        @WebInitParam(name="name", value="小明"),
        @WebInitParam(name="pwd", value="123456")})
public class MyServlet implements Servlet {

    private ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init方法启动");
        this.config=servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig方法启动");

        return config;
    }
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html");
        PrintWriter pw=servletResponse.getWriter();
        pw.write("1213123213-service yisa"+this.getServletConfig().getInitParameter("name"));
        System.out.println("service方法启动");
        this.config.getServletContext().setAttribute("aa","我爱白云");
        pw.append("往ServletContext置放属性aa");

    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo方法启动");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy方法启动");
    }
}
