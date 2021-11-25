package com.example.demo.pingshi.spring.mybean.myauto.autowiredother;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @description
 * @date 2021-11-25 18:28
 */

@Configuration
public class Need {

    @Bean
    public List<String> aa(){
        return Arrays.asList("c","d");
    };
}
