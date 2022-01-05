package com.example.demo.pingshi.initorder;

/**
 * @author zhangyu
 * @description [静态变量/静态方法/静态块] [普通变量/普通方法/非静态块] [构造函数]
 * 1.所有方法无论静态还是非静态，只是实例化。不是执行
 * 2.父类>子类 静态>非静态
 * 3.父类普通然后执行父类构造函数再子类普通再子类构造器。而不是父类普通然后子类普通
 * @date 2021-10-28 09:10
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
