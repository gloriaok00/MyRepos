package com.example.demo.pingshi.myfinal;

import java.text.DecimalFormat;

/**
 *  @description final vs static
 *  @date  2022/10/13 09:29
 */
public class MyFinal2 {
    public static void main(String[] args) {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        System.out.println(myClass1.i);
        System.out.println(myClass1.j);
        System.out.println(myClass2.i);
        System.out.println(myClass2.j);
    }
}

class MyClass {
    static DecimalFormat df = new DecimalFormat("0.0000");
    public final String i = df.format(Math.random());
    public static String j = df.format(Math.random());
}
