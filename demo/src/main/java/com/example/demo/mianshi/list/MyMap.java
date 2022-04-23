package com.example.demo.mianshi.list;

import com.example.demo.pingshi.java8stream.Person;

import java.util.HashMap;

/**
 * @description 日常练习
 * @date 2022-04-23 12:47
 */

public class MyMap {

    public static void main(String[] args) {
        HashMap<Person,Person> map=new HashMap<>();
        Person p1=new Person("1",1);
        Person p2=new Person("1",1);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        //@Data重写了hashcode和equals方法
        System.out.println("对比:"+p1.equals(p2));
        //同一个对象发生了覆盖 存储对象时map里的key是对象的hashcode
        map.put(p1,p1);
        map.put(p2,p2);
        System.out.println(map.get(p1).hashCode());
        System.out.println(map.get(p2).hashCode());
        System.out.println(map.size());
    }
}
