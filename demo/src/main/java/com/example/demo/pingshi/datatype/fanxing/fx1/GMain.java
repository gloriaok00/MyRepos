package com.example.demo.pingshi.datatype.fanxing.fx1;

import com.example.demo.pingshi.java8stream.Person;

/**
 * @description 泛型类学习
 * @date 2022-02-05 22:05
 */

public class GMain {

    public static void main(String[] args) {
        Generic<Person> g1=new Generic<>(new Person("11",7));
        System.out.println(g1.getKey().getAge());

        Generic<String> g2=new Generic<>("dfdsf");
        System.out.println(g2.getKey());

        Generic g3=new Generic("ccc");
        System.out.println(g3.getKey());

        Generic g4=new Generic();
        g4.setKey("defaultKey");
        System.out.println(g4.getKey());
    }
}
