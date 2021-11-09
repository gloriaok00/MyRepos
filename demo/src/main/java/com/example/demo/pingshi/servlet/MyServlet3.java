package com.example.demo.pingshi.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description
 * @date 2021-11-09 14:06
 */

@WebServlet("/zz")
public class MyServlet3 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        //2.获得请求的资源相关的内容
        String requestURI = req.getRequestURI();//获得请求URI
        StringBuffer requestURL = req.getRequestURL();
        String webName = req.getContextPath();//获得应用路径（应用名称）
        String querryString = req.getQueryString();//获得查询字符串
        System.out.println(method);
        System.out.println(requestURI);
        System.out.println(requestURL);
        System.out.println(webName);
        System.out.println(querryString);
        this.getServletConfig().getServletContext();

        /* String result="";
        req.setCharacterEncoding("utf-8");
        BufferedReader br=req.getReader();
        int respInt = br.read();
        while(respInt!=-1) {
            result +=(char)respInt;
            respInt = br.read();
        }
        System.out.println("mm:"+result);*/
      /*  InputStreamReader insr = new InputStreamReader(req.getInputStream(),"utf-8");
        String result = "";
        int respInt = insr.read();
        while(respInt!=-1) {
            result +=(char)respInt;
            respInt = insr.read();
        }
        JSONObject jsonRet = JSONObject.parseObject(result);
        System.out.println("xx:"+jsonRet.toJSONString());*/

    }
}
