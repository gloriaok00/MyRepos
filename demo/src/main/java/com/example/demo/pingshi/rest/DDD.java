package com.example.demo.pingshi.rest;

/**
 * @author zhangyu
 * @description
 * @date 2020-06-17 09:46
 */

public class DDD {
    public static void main(String[] args) {
        Person p = new Person("woshishabi", "18");
        add(p);
        System.out.println(p.toString());
    }

    public static void add(Person p) {
        p.setAge("78");
    }
}
