package com.example.demo.pingshi.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description
 * @date 2022/8/9 11:32
 */
//@Component
@Order(56)
public class MyFilter4 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        System.out.println("111:"+response.getHeader("h1"));
        System.out.println("222:"+response.getHeader("h2"));
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
