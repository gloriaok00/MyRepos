package com.example.demo.pingshi.classloader.c4;

/**
 * @description 是loadClass仅仅是加载
 * https://blog.csdn.net/CaptHua/article/details/120925452
 * @date 2022/9/19 11:01
 */

public class MyLoadClass {

    public static void main(String[] args) throws Exception {
        MyLoadClass m = new MyLoadClass();
        m.show();
    }

    public void show() throws Exception {
        //loadClass不会触发类的初始化 仅仅是加载
        Class zz = this.getClass().getClassLoader().loadClass("com.example.demo.pingshi.initorder.i4.I4");
        System.out.println(zz.getName());
        //Class.forName则会触发类的初始化
        Class zz1 = Class.forName("com.example.demo.pingshi.initorder.i4.I4");
        System.out.println("bbb:" + zz1.getName());
    }
}
