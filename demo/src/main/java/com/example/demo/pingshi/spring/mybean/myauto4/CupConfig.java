package com.example.demo.pingshi.spring.mybean.myauto4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description
 * @date 2022-01-03 15:15
 */

@Configuration
public class CupConfig {

    @Bean(name = "b1")
    public Cup cup() {
        return new SmallCup();
    }

    @Bean(name = "b22")
    public Cup cup2() {
        return new BigCup();
    }
}
