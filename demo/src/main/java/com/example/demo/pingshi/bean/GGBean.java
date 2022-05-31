package com.example.demo.pingshi.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @description 在这里注入的BBean
 * @date 2022/5/31 14:58
 */

@Component
public class GGBean {

    @Bean
    public BBean BBean() {
        return new BBean();
    }
}
