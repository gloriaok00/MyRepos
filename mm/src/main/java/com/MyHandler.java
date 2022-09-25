package com;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHandler implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //装载模型数据和逻辑视图
        ModelAndView modelAndView = new ModelAndView();
        //添加模型数据
        modelAndView.addObject("name", "Tom");
        //添加逻辑视图
        modelAndView.setViewName("show");
        return modelAndView;
    }

}
