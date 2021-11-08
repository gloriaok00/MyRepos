package com.example.demo.pingshi.servlet;

import cn.hutool.core.util.ObjectUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description
 * @date 2021-11-08 15:46
 */

@WebServlet(urlPatterns = "/aa")
public class MyServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter pw=resp.getWriter();
        pw.write("s我是中文herewr");
        if(ObjectUtil.isNotEmpty(super.getServletConfig().getServletContext().getAttribute("aa"))){
            pw.append("我是从ServletConfig的aa中取出的:"+super.getServletConfig().getServletContext().getAttribute("aa"));
        }
    }
}
