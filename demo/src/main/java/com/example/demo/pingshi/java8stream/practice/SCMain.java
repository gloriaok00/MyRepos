package com.example.demo.pingshi.java8stream.practice;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description
 * @date 2022-03-31 12:58
 */

public class SCMain {

    public static void main(String[] args) {

        SS s1 = new SS(23, "1号",34);
        SS s2 = new SS(123, "2号",56);
        SS s3 = new SS(3, "3号",41);
        SS s4 = new SS(9, "4号",114);

        //System.out.println(s2.compareTo(s3));

        List<SS> ll=new ArrayList<>();
        ll.add(s1);
        ll.add(s2);
        ll.add(s3);
        ll.add(s4);

        //内部比较器
        //Collections.sort(ll);
        //ll.forEach(System.out::println);

        List<SS> st=ll.stream().sorted(Comparator.comparingInt(SS::getA)).collect(Collectors.toList());
        st.forEach(e->{
            System.out.println(e.toString());
        });

        System.out.println("========");
        List<SS> st1=ll.stream().sorted(Comparator.comparingInt(SS::getC)).collect(Collectors.toList());
        st1.forEach(e->{
            System.out.println(e.toString());
        });

        Map<Integer,SS> mm=new HashMap<>();
        mm.put(s1.getA(),s1);
        mm.put(s2.getA(),s2);
        mm.put(s3.getA(),s3);
        mm.put(s4.getA(),s4);
        System.out.println("========");
        System.out.println("排序前:");
        mm.forEach((k,v)->{
            System.out.println(v.toString());
        });
        System.out.println("排序后:");
        mm.entrySet().stream()
                .sorted(Map.Entry.<Integer,SS>comparingByKey().reversed())
                .forEach(System.out::println);
        System.out.println("========");
        List<SSS> ll2=new ArrayList<>();
        SSS sss1 = new SSS(23, "1号");
        SSS sss2 = new SSS(123, "2号");
        SSS sss3 = new SSS(3, "3号");
        SSS sss4 = new SSS(9, "4号");

        ll2.add(sss1);
        ll2.add(sss2);
        ll2.add(sss3);
        ll2.add(sss4);

        //外部比较器
        Collections.sort(ll2, new Comparator<SSS>() {
            public int compare(SSS o1, SSS o2) {
                return Integer.compare(o1.getA(),o2.getA());
            }
        });
        ll2.forEach(System.out::println);
    }
}
