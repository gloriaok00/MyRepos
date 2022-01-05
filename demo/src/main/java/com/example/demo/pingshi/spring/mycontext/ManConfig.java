package com.example.demo.pingshi.spring.mycontext;

import com.example.demo.pingshi.spring.mybean.myauto.Man;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description
 * @date 2021-11-19 10:51
 */

@Configuration
public class ManConfig {

    @Bean
    public Man getMyMan() {
        return new Man();
    }
}
