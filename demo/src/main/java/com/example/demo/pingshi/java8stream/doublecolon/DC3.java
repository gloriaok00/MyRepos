package com.example.demo.pingshi.java8stream.doublecolon;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description
 * @date 2022-03-09 20:44
 */

public class DC3 {

    public static void getCon1(String con){
        System.out.println(con);
    }

    @Test
    public void start() {
        String[] arr={"s1","s2","s3"};
        List<String> ll=Arrays.asList(arr);
        ll.forEach(
            DC3::getCon1
        );
        ll.forEach(System.out::println);
    }

    @Test
    public void ss(){
        Integer[] arr={1,2,3};
        List<Integer> ll=Arrays.asList(arr);
        List<Integer> ll1=ll.stream().map(e->e+1).collect(Collectors.toList());
        ll1.forEach(System.out::println);
    }

    @Test
    public void showPrint(){
       List<UUID> aa=new ArrayList<>();
       aa.add(UUID.randomUUID());
       aa.add(UUID.randomUUID());
       aa.add(UUID.randomUUID());
       aa.add(UUID.randomUUID());
       List<String> aa1=new ArrayList<>();
       aa1=aa.stream().map(UUID::toString).collect(Collectors.toList());
       //aa1=aa.stream().map(e->e.toString()).collect(Collectors.toList());
        aa1.forEach(System.out::println);
    }

    @Test
    public void convertTest(){

        List<String> collected = new ArrayList<>();
        collected.add("alpha");
        collected.add("beta");
        collected = collected.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collected);

    }
}
