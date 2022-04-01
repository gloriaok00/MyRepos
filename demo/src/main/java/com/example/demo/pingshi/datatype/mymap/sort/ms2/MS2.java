package com.example.demo.pingshi.datatype.mymap.sort.ms2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @date 2022-04-01 10:22
 */

public class MS2 {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 1020);
        map.put(3, 300);
        map.put(1, 100);
        map.put(5, 500);

        List<Map.Entry<Integer,Integer>> ll=new ArrayList<>(map.entrySet());
        ll.sort(Map.Entry.comparingByValue());
        ll.forEach(System.out::println);

    }
}
