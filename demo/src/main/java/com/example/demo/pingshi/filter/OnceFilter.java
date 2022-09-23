package com.example.demo.pingshi.filter;

import com.example.demo.mbs.cus.dao.UserDao;
import com.example.demo.mbs.cus.dto.UUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @description
 * @date 2022/7/18 16:42
 */

//@Component
public class OnceFilter extends OncePerRequestFilter {

    @Autowired
    private UserDao userDao;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("woaini");
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    @Override
    protected void initFilterBean() throws ServletException {
        System.out.println("走了吗");
        List<UUser> users=userDao.sqlCusShow();
        System.out.println("xxx111:"+users.size());
    }

}
