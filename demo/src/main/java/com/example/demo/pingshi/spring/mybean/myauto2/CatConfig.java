package com.example.demo.pingshi.spring.mybean.myauto2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description
 * @date 2022-01-02 22:43
 */

@Configuration
public class CatConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Cat cat() {
        return new Cat();
    }

  /*  @Bean
    public A1 a1() {
        return new A1();
    }*/
}
