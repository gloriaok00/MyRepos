package com.example.demo.pingshi.myreflection.lc;

public class ClassLoadTest {

    public static void main(String args[]) throws Exception{
        System.out.println();
        //不会引起类的初始化 只会加载
        Class c1 = LC.class;
        //forName会引起初始化
        //Class c1 = Class.forName("com.example.demo.pingshi.myreflection.lc.LC");
        System.out.println();
    }

}
