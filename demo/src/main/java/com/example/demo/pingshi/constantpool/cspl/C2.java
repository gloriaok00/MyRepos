package com.example.demo.pingshi.constantpool.cspl;

/**
 * @description
 * @date 2022/10/6 00:19
 */

public class C2 {

    public static void main(String[] args) {
        String str1 = new String("SEU") + new String("Calvin");
        System.out.println(str1.intern() == str1);
        System.out.println(str1 == "SEUCalvin");

    }

}
