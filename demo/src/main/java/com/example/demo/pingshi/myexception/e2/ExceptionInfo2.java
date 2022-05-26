package com.example.demo.pingshi.myexception.e2;

/**
 * @description
 * @date 2022/5/27 00:40
 */

public class ExceptionInfo2 {
    private static int m = 0;

    public static void main(String[] args) {
        System.out.println("test exception");
        try {
            m = 899 / 0;
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
    }
}
