package com.example.demo.pingshi.datatype;

/**
 * @description
 * @date 2021-12-14 21:16
 */

public class Plus {

    public static void main(String[] args) {
        int result = test1();
        System.out.println(result);
    }

    public static int test1() {
        int i = 1;
        try {
            ++i;
            System.out.println("try block, i = " + i);
        } catch (Exception e) {
            i--;
            System.out.println("catch block i = " + i);
        } finally {
            i = 10;
            System.out.println("finally block i = " + i);
        }
        return i;
    }
}
