package com.example.demo.pingshi.myfinal;

/**
 * @description
 * @date 2021-11-12 08:48
 */

public class MyFinal {

    public static void main(String[] args) {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;
        System.out.println((a == c));
        System.out.println((a == e));
        Person p = new Person();

    }
}

class Person {

}
