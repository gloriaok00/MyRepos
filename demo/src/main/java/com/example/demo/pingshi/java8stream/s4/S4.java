package com.example.demo.pingshi.java8stream.s4;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description 随机练习
 * @date 2022/12/8 13:17
 */

public class S4 {

    @Test
    public void test14() {
        Map<String, Integer> m1 = ImmutableMap.of("a", 2, "b", 3);
        Map<String, Integer> m2 = ImmutableMap.of("d", 3, "c", 4);

        Map<String, Integer> xx = Stream.of(m1, m2).collect(Collectors.toMap(Map::toString, Map::size));
        xx.entrySet().forEach(ee -> {
            System.out.println("键:" + ee.getKey() + ",值:" + ee.getValue());
        });

        System.out.println("==============");
        Map<String, Integer> xx1 = Stream.of(m1, m2).map(Map::entrySet).flatMap(Collection::stream).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        xx1.entrySet().forEach(ee -> {
            System.out.println("键:" + ee.getKey() + ",值:" + ee.getValue());
        });
    }

    @Test
    public void xx() {
        //这个ImmutableMap不是jdk里的api
        Map<String, Object> iMap = new ImmutableMap.Builder<String, Object>()
                .put("k1", "v1")
                .put("k2", "v2")
                .build();
        //iMap.put("1","2");
    }
}
