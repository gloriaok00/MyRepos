package com.example.demo.pingshi.box;

/**
 * @description 随机练习
 * @date 2022/10/9 11:42
 */

public class MyBox {

    public static void main(String[] args) {
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);
        System.out.println(i1 == i2);
        System.out.println(i1 == i2 + i3);
        System.out.println(i1 == i4);
        System.out.println(i4 == i5);
        System.out.println(i4 == i5 + i6);
        System.out.println(40 == i5 + i6);
    }
}
