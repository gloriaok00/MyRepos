package com.example.demo.pingshi.initorder.i2;

/**
 * @description 父cinit 子cinit 父init(全局+构造器) 子init(全局+构造器)
 * @date 2022-05-12 14:15
 * @date 2022-09-18 20:57
 */

public class I2 {
    public static void main(String[] args) {
        Father ts = new Son();
    }
}

class Father {
    {
        System.out.println("父类 非静态块 2  执行");
    }

    static {
        System.out.println("父类 static块 2  执行");
    }

    static Sample staticSam1 = new Sample("父类 静态成员 staticSam1 初始化");
    Sample sam1 = new Sample("父类 普通成员 sam1 初始化");
    static Sample staticSam2 = new Sample("父类 静态成员 staticSam2 初始化");

    static {
        System.out.println("父类 static块 1  执行");
    }

    Father() {
        System.out.println("父类 默认构造函数被调用");
    }

    Sample sam2 = new Sample("父类 普通成员 sam2 初始化");

    {
        System.out.println("父类 非静态块 1  执行");
    }

}

class Son extends Father {
    {
        System.out.println("子类 非静态块 1  执行");
    }

    static Sample staticSamSub1 = new Sample("子类 静态成员 staticSamSub1 初始化");

    Son() {
        System.out.println("子类 默认构造函数被调用");
    }

    Sample sam1 = new Sample("子类 普通成员 sam1 初始化");
    static Sample staticSamSub2 = new Sample("子类 静态成员 staticSamSub2 初始化");

    static {
        System.out.println("子类 static块2  执行");
    }

    {
        System.out.println("子类 非静态块 2  执行");
    }

    Sample sam2 = new Sample("子类 普通成员 sam2 初始化");

    static {
        System.out.println("子类 static块1  执行");
    }
}

class Sample {
    Sample(String s) {
        System.out.println(s);
    }

    Sample() {
        System.out.println("Sample默认构造函数被调用");
    }
}
