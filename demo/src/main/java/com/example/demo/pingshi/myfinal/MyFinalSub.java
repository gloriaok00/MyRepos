package com.example.demo.pingshi.myfinal;

/**
 * @description
 * @date 2022-02-17 22:51
 */

public class MyFinalSub{

    public final void show(){
        System.out.println("我是final方法，不能被重写");
    }

    public void show1(){
        System.out.println("我不是final方法，可以被重写");
    }
}
