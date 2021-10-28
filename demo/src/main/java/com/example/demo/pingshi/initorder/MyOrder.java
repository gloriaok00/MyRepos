package com.example.demo.pingshi.initorder;

/**
 * @author zhangyu
 * @description  静态块 [静态变量/静态方法] [普通变量/普通方法] [构造函数]
 * 所有方法无论静态还是非静态，只是实例化。不是执行
 * @date 2021-10-28 09:10
 */

public class MyOrder {
    static{
        System.out.println("静态块");
    };
    public  subA subB=new subA("非静态变量");
    public static void getSS(){
        System.out.println("静态方法");
    }

    public MyOrder(String a){
        System.out.println("构造函数MyOrder:"+a);
    }
    {
        System.out.println("非静态块");
    }
    public void getNonSS(){
        System.out.println("非静态方法");
    }
    public static subA subA=new subA("静态变量");


    public static void main(String[] args) {
        MyOrder a=new MyOrder("MyOrder啊");
    }
}

class subA{
    subA(String a){
        System.out.println("构造函数subA:"+a);
    }
}
