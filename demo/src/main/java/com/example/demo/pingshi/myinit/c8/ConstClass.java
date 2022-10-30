package com.example.demo.pingshi.myinit.c8;

/**
 * @description 读书笔记:
 * 《深入理解java虚拟机》
 * 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化。
 * @date 2022/10/30 21:38
 */

public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD = "hello world";
}

