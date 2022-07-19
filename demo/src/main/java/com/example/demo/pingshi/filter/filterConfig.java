package com.example.demo.pingshi.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description FilterRegistrationBean
 * @date 2022/7/19 15:45
 */

@Configuration
public class filterConfig {

    @Bean
    public FilterRegistrationBean<MyFilter3> myFilter3() {
        MyFilter3 filter = new MyFilter3();
        FilterRegistrationBean<MyFilter3> registration = new FilterRegistrationBean<>();
        registration.setFilter(filter);
        registration.addUrlPatterns("/ddd", "/ttt");
        //设置顺序
        //registration.setOrder(66);
        return registration;
    }

}
