package com.example.demo.pingshi.java8stream;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhangyu
 * @date 2019-11-06 20:11
 */
public class MapDemo {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "AAAA");
        map.put("2", "BBBB");
        map.put("0", "BBBB");
        map.put("6", "BBBB");
        map.put("3", "CCCC");
        map.put("4", "DDDD");
        map.put("5", "EEEE");
        map.entrySet().stream().sorted(Map.Entry.<String, String>comparingByKey()).map(e -> e.getKey() + e.getValue()).collect(Collectors.toList()).forEach(e -> System.out.println(e));
    }
}
