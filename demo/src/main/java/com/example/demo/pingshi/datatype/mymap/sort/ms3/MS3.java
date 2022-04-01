package com.example.demo.pingshi.datatype.mymap.sort.ms3;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @description
 * @date 2022-04-01 10:35
 */

public class MS3 {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 1020);
        map.put(3, 300);
        map.put(1, 100);
        map.put(5, 500);

        Stream<Map.Entry<Integer, Integer>> mapSorted=map.entrySet().stream().sorted(Map.Entry.comparingByValue());
        mapSorted.forEach(System.out::println);
    }

}
