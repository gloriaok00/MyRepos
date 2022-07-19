package com.example.demo.pingshi.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description 通过FilterRegistrationBean加入
 * @date 2022/7/18 23:54
 */

//单纯的过滤器
public class MyFilter3 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我是F3");
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        response.addHeader("Cache-Control", "max-age=0,no-cache,no-store,post-check=0,pre-check=0");
        response.addHeader("Expires", "Mon, 26 Jul 1997 05:00:00 GMT");
        filterChain.doFilter(servletRequest, servletResponse);
        response.addHeader("xx", "bb");
        response.addHeader("bb", "mm");
    }
}
