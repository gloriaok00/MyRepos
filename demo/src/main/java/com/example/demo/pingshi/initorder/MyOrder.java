package com.example.demo.pingshi.initorder;

/**
 * @description 随机练习
 * @date 2021-10-28 09:10
 * @date 2022-05-12 16:11
 */

public class MyOrder {
    public subA subB = new subA("非静态变量1");

    public static void getSS() {
        System.out.println("静态方法");
    }

    public MyOrder(String a) {
        System.out.println("构造函数MyOrder:" + a);
    }

    public subA subBB = new subA("非静态变量2");

    static {
        System.out.println("静态块");
    }

    ;

    public void getNonSS() {
        System.out.println("非静态方法");
    }

    public static subA subA = new subA("静态变量");

    {
        System.out.println("非静态块");
    }

    public static void main(String[] args) {
        MyOrder a = new MyOrder("MyOrder啊");
    }
}

class subA {
    subA(String a) {
        System.out.println("构造函数subA:" + a);
    }
}
