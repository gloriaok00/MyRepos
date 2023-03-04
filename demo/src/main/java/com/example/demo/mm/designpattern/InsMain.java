package com.example.demo.mm.designpattern;

/**
 * @description
 * @date 2023/3/4 10:46
 */

public class InsMain {

    public static void main(String[] args) {
        InsDemo xx1=InsDemo.getInstance();
        InsDemo xx2=InsDemo.getInstance();
        InsDemo xx3=InsDemo.getInstance();
        System.out.println(xx1==xx2);
        System.out.println(xx2==xx3);
    }
}
