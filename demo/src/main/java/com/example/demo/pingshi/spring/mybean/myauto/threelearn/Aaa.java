package com.example.demo.pingshi.spring.mybean.myauto.threelearn;

import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2021-11-26 13:23
 */

@Component
public class Aaa implements All {

    public int a = 23;

    @Override
    public void show() {
        System.out.println("我是AAA");
    }
}
