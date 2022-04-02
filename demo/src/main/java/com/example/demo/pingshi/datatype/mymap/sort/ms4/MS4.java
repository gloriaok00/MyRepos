package com.example.demo.pingshi.datatype.mymap.sort.ms4;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * @description
 * @date 2022-04-02 08:49
 */

public class MS4 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(2, 1020);
        map.put(3, 300);
        map.put(1, 100);
        map.put(5, 500);
        map.entrySet().forEach(System.out::println);
        System.out.println("After Sorting by value");
        Map<Integer, Integer> result = map.entrySet().stream()
                .sorted(Entry.comparingByValue())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue,(k,v)->k, LinkedHashMap::new));
        result.entrySet().forEach(System.out::println);
    }
}
