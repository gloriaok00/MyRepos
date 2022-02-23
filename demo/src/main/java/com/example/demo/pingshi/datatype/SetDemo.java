package com.example.demo.pingshi.datatype;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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
        System.out.println("没remove之前的size:"+l1.size());
        Set<Long> l2=new HashSet<>();
        l2.add(3L);
        l2.add(33L);
        l1.removeAll(l2);
        System.out.println("remove之后的size:" + l1.size());

        List<String> xx=Collections.singletonList("sdsa");
        System.out.println(xx.size());

        Set<String> xx1=Collections.singleton("sdsa");
        System.out.println(xx1.size());

        Long l3=3L;
        Long l4=3L;
        if(l3.equals(l4)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
