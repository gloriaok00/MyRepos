package com.example.demo.pingshi.initorder;

/**
 * @description 再练习
 * @date 2021-10-28 09:10
 * @date 2022-05-12 16:11
 * @date 2022-09-19 13:20
 */

public class MyOrder {

    public OtherO subB = new OtherO("非静态变量1");

    public static void getSS() {
        System.out.println("静态方法");
    }

    public MyOrder(String a) {
        System.out.println("构造函数MyOrder:" + a);
    }

    public OtherO subBB = new OtherO("非静态变量2");

    static {
        System.out.println("静态块");
    }

    public void getNonSS() {
        System.out.println("普通方法");
    }

    public static OtherO subA = new OtherO("静态变量");

    {
        System.out.println("非静态块");
    }

    public static void main(String[] args) {
        MyOrder a = new MyOrder("MyOrder啊");
    }
}

class OtherO {
    OtherO(String a) {
        System.out.println("构造函数subA:" + a);
    }
}
