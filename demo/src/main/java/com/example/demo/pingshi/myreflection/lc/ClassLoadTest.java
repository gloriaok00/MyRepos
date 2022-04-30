package com.example.demo.pingshi.myreflection.lc;

public class ClassLoadTest {

    public static void main(String args[]) {
        System.out.println();
        //不会引起类的初始化 只会加载
        Class c1 = lC.class;
        System.out.println();
    }

}
