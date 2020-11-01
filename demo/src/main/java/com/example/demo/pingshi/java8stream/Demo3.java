package com.example.demo.pingshi.java8stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhangyu
 * @date 2019-11-07 13:46
 */
public class Demo3 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "apple");
        map.put(20, "orange");
        map.put(22, "orange111");
        map.put(30, "banana");
        map.put(40, "watermelon");
        map.put(50, "dragonfruit");

        List<String> resultValues = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
                .map(x -> x.getKey()+"-"+x.getValue())
                .collect(Collectors.toList());
        resultValues.forEach(System.out::println);
    }
}
