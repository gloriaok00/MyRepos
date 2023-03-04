package com.example.demo.mm.designpattern;

/**
 * @description
 * @date 2023/3/4 10:46
 */

public class InsMain2 {

    public static void main(String[] args) {
        InsDemo2 d2=InsDemo2.getInstance();
        InsDemo2 d21=InsDemo2.getInstance();
        InsDemo2 d22=InsDemo2.getInstance();
        System.out.println(d2==d21);
        System.out.println(d21==d22);
    }
}
