package com.example.demo.pingshi.initorder;

import javax.annotation.PostConstruct;
import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @description
 * @date 2021-12-14 10:34
 */

@WebServlet(urlPatterns = "/mytree1",initParams = {
        @WebInitParam(name="t_root", value="11"),
        @WebInitParam(name="t_leaf", value="22")})
public class TreeObjServlet implements Servlet {

    private ServletConfig config;

    private String t_root;
    private String t_leaf;

    TreeObjServlet() {
        System.out.println("11111111");
    }


    public TreeObjServlet(String t_root, String t_leaf) {
        this.t_root = t_root;
        this.t_leaf = t_leaf;
        System.out.println("i am constructor这里不是1，servlet这里只能加载无参数的构造器");
    }

    @PostConstruct
    public void preInit(){
        System.out.println("好像有点能理解PostConstruct的位置了2");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init3-只有一次，servlet是懒加载，调的时候才执行");
        this.config=servletConfig;
        this.t_root= config.getInitParameter("t_root");
        this.t_leaf= config.getInitParameter("t_leaf");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig");
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service4-调一次执行一次");
        System.out.println(getT_root());
        System.out.println(getT_leaf());
        System.out.println(servletRequest.getAttribute("a"));
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    public String getT_root(){
        return this.t_root;
    }

    public String getT_leaf(){
        return this.t_leaf;
    }
}
