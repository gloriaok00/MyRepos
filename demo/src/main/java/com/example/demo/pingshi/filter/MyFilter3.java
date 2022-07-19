package com.example.demo.pingshi.filter;

import javax.servlet.*;
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
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
