package com.example.demo.pingshi.initorder.i4;

/**
 * @description 再练习
 * @date 2022/5/15 22:00
 * @date 2022/09/18 22:54
 * @date 2022/10/29 13:33
 */
public class I4 {

    public I4() {//构造函数
        System.out.println("构造函数");
    }

    {//构造代码块
        System.out.println("构造代码块");
    }

    static {//静态代码块
        System.out.println("静态代码块");
    }

    public static void main(String[] args) {
        I4 a = new I4();
        System.out.println("dfsdfsdf");
    }
}
