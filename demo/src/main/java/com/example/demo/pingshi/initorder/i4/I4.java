package com.example.demo.pingshi.initorder.i4;

/**
 *  @description  不生成对象时 不会调用构造器的
 *  @date  2022/5/15 22:00
 */
public class I4 {

    public I4() {//构造函数
        System.out.println("A的构造函数");
    }

    {//构造代码块
        System.out.println("A的构造代码块");
    }

    static {//静态代码块
        System.out.println("A的静态代码块");
    }

    public static void main(String[] args) {
        //I4 a=new I4();
    }
}
