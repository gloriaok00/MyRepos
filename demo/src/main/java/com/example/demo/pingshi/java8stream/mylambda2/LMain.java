package com.example.demo.pingshi.java8stream.mylambda2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description
 * @date 2021-12-30 01:41
 */

public class LMain {

    public static void main(String[] args) {
        //list转map对象
        Apple a1=new Apple(1,1.1);
        Apple a2=new Apple(2,2.2);
        Apple a3=new Apple(3,3.3);
        List<Apple> appleList= Arrays.asList(a1,a2,a3);
        Map<Integer,Apple> appleMap=appleList.stream().collect(Collectors.toMap(
                Apple::getJin,a->new Apple(a.getJin(),a.getPrice())));
        appleMap.forEach((k,v)->{
            System.out.println("k is"+k);
            System.out.println("v is"+v.toString());
        });
        //map转list对象
        Map<Integer,Apple> map1=new HashMap<>();
        map1.put(a1.getJin(),a1);
        map1.put(a2.getJin(),a2);
        map1.put(a3.getJin(),a3);
        List<Apple> appleList1=map1.values().stream().collect(Collectors.toList());
        List<Apple> appleList2=new ArrayList<>(map1.values());
        appleList1.forEach(e->{
            System.out.println(e.getJin());
            System.out.println(e.getPrice());
        });
    }
}
