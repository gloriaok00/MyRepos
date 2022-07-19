package com.example.demo.pingshi.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @description @WebFilter注解代替之前的web.xml里的配置
 * @date 2022/7/19 11:01
 */

@WebFilter(filterName = "F1", urlPatterns = "/ddd", initParams = {
        @WebInitParam(name = "code", value = "index.jsp;fail.jsp;/LoginServlet")
})
public class MyFilter1 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我是F1");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //启动时仅一次执行 可以对一些变量初始化
        System.out.println("参数有了吧:" + filterConfig.getInitParameter("code"));
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
