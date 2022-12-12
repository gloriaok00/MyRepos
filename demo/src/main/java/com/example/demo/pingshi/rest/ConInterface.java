package com.example.demo.pingshi.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description Controller接口
 * @date 2022/12/12 22:55
 */

@org.springframework.stereotype.Controller("/con/face")
@Slf4j
public class ConInterface implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("日志");
        return null;
    }
}
