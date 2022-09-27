package com.example.demo.pingshi.servlet;

import cn.hutool.core.util.ObjectUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @description 随机练习
 * @date 2021-11-08 15:46
 * @date 2022-09-27 23:42
 */

@WebServlet(urlPatterns = "/aa")
public class MyServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.write("s我是中文her");
        if (ObjectUtil.isNotEmpty(super.getServletConfig().getServletContext().getAttribute("aa"))) {
            pw.append("我是从ServletConfig的aa中取出的:" + super.getServletConfig().getServletContext().getAttribute("aa"));
        }

        InputStream stream = getServletContext().getClassLoader().getResourceAsStream("application.properties");
        InputStreamReader inReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(inReader);
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
