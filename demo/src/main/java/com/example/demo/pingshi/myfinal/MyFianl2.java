package com.example.demo.pingshi.myfinal;

import com.example.demo.pingshi.session.Book;

/**
 * @description
 * @date 2022-02-17 22:53
 */

public class MyFianl2 extends MyFinalSub{

    @Override
    public void show1() {
        super.show1();
        System.out.println("重写非final");
    }

    public static void main(String[] args) {
        final int a = 1023;
        //a=2;
        System.out.println(a);
        final Book b=new Book(1,"我的奋斗");
        //对于一个final变量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；
        //如果是引用类型的变量，则在对其初始化之后便不能再让其指向另一个对象。
        b.setId(2);
        b.setName("我的奋斗2");
        //b=new Book(3,"我的奋斗3");
        System.out.println(b);
    }
}
