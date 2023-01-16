package com.example.demo.mianshi.list.l4;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description
 * @date 2023/1/16 21:35
 */

public class L4 {

    public static void main(String[] args) {
        TreeMap<Person22, String> treeMap = new TreeMap<Person22, String>();
        Person22 p1 = new Person22("zy", 1);
        Person22 p2 = new Person22("zyfd", 9);
        Person22 p3 = new Person22("zysfdsf", 4);
        Person22 p4 = new Person22("ads", 12);
        treeMap.put(p1, "1号");
        treeMap.put(p2, "2号");
        treeMap.put(p3, "3号");
        treeMap.put(p4, "4号");
        Iterator<Map.Entry<Person22, String>> it = treeMap.entrySet().iterator();
        while(it.hasNext()){
            System.out.println(it.next().getKey().getAge());
        }
    }
}
