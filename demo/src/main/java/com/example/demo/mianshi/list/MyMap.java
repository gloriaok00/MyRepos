package com.example.demo.mianshi.list;

import com.example.demo.pingshi.java8stream.Person;

import java.util.HashMap;

/**
 * @description
 * @date 2022-02-04 21:32
 */

public class MyMap {

    public static void main(String[] args) {
        HashMap<String,Person> map=new HashMap<>();
        Person p1=new Person("1",1);
        Person p2=new Person("1",1);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        map.put("1",p1);
        map.put("2",new Person("2",2));
        System.out.println(map.get("1").hashCode());
    }
}
