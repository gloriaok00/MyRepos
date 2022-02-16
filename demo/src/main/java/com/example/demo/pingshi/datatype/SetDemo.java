package com.example.demo.pingshi.datatype;

import java.util.HashSet;
import java.util.Set;

/**
 * @description
 * @date 2022-02-16 18:48
 */

public class SetDemo {

    public static void main(String[] args) {
        //List<Long> l1= new ArrayList<>();
        Set l1=new HashSet<>();
        l1.add(4L);
        l1.add(2L);
        l1.add(3L);
        l1.add(3L);
        l1.add(33L);
        l1.add(33L);
        l1.forEach(System.out::println);
        System.out.println("size:"+l1.size());
        Set<Long> l2=new HashSet<>();
        l2.add(3L);
        l2.add(33L);
        l1.removeAll(l2);
        l1.forEach(System.out::println);
    }
}
