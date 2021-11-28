package com.example.demo.pingshi.servlet;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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
        System.out.println("我是init方法，我是3");
        this.config=servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig方法启动");

        return config;
    }
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("我是service方法，我是4");
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
        System.out.println("我是destroy方法，我是5");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("我是preDestroy方法，我是6.在Destroy之后执行。为啥在他之后执行还叫pre");
    }

    /**
     * 构造方法执行之后，调用此方法
     */
    @PostConstruct
    public void beforeInit(){
        System.out.println("我是@PostConstruct方法,我是2.在构造方法之后，init()之前会被调");
        System.out.println("而且全局范围内只启动一次");
    }

    public MyServlet(ServletConfig config) {
        this.config = config;
        System.out.println("我是构造器，我是1");
    }
}
