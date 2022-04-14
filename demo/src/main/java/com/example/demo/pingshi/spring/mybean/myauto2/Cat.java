package com.example.demo.pingshi.spring.mybean.myauto2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author binghe
 * @version 1.0.0
 * @description 测试@PostConstruct注解和@PreDestroy注解
 */
public class Cat {

    public Cat() {
        System.out.println("Cat类的构造方法...");
    }

    public void init() {
        System.out.println("Cat的init()方法...");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Cat的postConstruct()方法...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Cat的preDestroy()方法...");
    }

    public void destroy() {
        System.out.println("Cat的destroy()方法...");
    }
}
