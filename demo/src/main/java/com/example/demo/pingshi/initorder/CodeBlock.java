package com.example.demo.pingshi.initorder;

/**
 *  @description 静态代码块每当实例化对象时就会被调用
 *  @date  2022/5/12 14:34
 */

public class CodeBlock {

    CodeBlock() {
        System.out.println("无参构造器");
    }

    static {
        System.out.println("静态代码块被执行");
    }

    {
        System.out.println("非静态代码块被执行");
    }

    public void show() {
        System.out.println("类方法被执行");
    }

    public static void main(String[] args) {
        System.out.println("main方法被执行");
        new CodeBlock().show();
        new CodeBlock().show();
    }
}
