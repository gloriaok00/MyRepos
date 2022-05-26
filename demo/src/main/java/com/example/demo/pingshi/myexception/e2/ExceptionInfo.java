package com.example.demo.pingshi.myexception.e2;


/**
 * @description
 * @date 2022/5/27 00:39
 */

public class ExceptionInfo {
    private static String str = null;

    public static void main(String[] args) {
        System.out.println("test exception");
        try {
            if (str.equals("name")) {
                System.out.println("test exception");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
    }
}
