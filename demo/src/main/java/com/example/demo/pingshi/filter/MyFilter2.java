package com.example.demo.pingshi.filter;

import com.example.demo.mbs.cus.dao.UserDao;
import com.example.demo.mbs.cus.dto.UUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @description 但这样不能定制化想要拦截的url了
 * @date 2022/7/18 23:54
 */

//直接采用组件引进来也行
//@Component
@Order(55)
public class MyFilter2 implements Filter {

    @Autowired
    private UserDao userDao;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我是F2");
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        response.addHeader("h1","h1");
        filterChain.doFilter(servletRequest, servletResponse);
        response.addHeader("h2","加在doFilter后已经没用了");

        List<UUser> users=userDao.sqlCusShow();
        System.out.println("xxx333:"+users.size());

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //这里由于没有在web.xml里或注解里给出init-param 所以是Null
        String code = filterConfig.getInitParameter("code");
        System.out.println("11111init:" + code);

        List<UUser> users=userDao.sqlCusShow();
        System.out.println("xxx2222:"+users.size());
    }
}
