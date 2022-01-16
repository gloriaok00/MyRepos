package com.example.demo.pingshi.spring.mybean.myauto4;

import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2022-01-16 21:11
 */

@Component
public class MyDog implements Dog{

    @Override
    public String wangwang() {
        return "my dog is wangwanging";
    }
}
