package com.example.demo.pingshi.myobj.e1;

/**
 * @description
 * @date 2022/11/28 10:55
 */

public class SE1 {

    public static int a=1;
    static {
        System.out.println("静态的东西也是一样的 " +
                "不被调的时候是不会先把整个类装载进去的,是由于正向引用到了这个类才引起了初始化 " +
                "从而跑了静态的逻辑");
    }
}
