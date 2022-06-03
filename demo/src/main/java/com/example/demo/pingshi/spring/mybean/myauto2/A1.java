package com.example.demo.pingshi.spring.mybean.myauto2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @description
 * @date 2022-01-02 22:03
 * @date 2022-06-03 23:23
 */

@Component
public class A1 {

    @Autowired
    private A2 b;

    public A1() {
        System.out.println("我是A1默认构造器");
        System.out.println("此时b: b = "+b);
    }

    public A1(A2 b) {
        this.b = b;
        System.out.println("此时b: b = "+b.toString());
    }

    @PostConstruct
    public void show(){
        System.out.println("111@PostConstruct将在依赖注入完成后被自动调用: b = " + b);
    }
}

@Component
class A2{

    private String s="我是A2";

}
