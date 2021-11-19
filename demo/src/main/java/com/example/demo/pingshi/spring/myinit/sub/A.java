package com.example.demo.pingshi.spring.myinit.sub;

import org.springframework.stereotype.Component;

/**
 * @author zhangyu
 * @description
 * @date 2021-10-22 16:37
 */

@Component
public class A {

    public void show(){
        System.out.println("这是被spring容器实例化后的A对象的show方法");
    }
}
