package com.example.demo.pingshi.java8stream.s3;

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

        Map<String, Integer> xx = Stream.of(m1, m2).map(Map::entrySet).flatMap(Collection::stream).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        xx.entrySet().forEach(ee -> {
            System.out.println("键:" + ee.getKey() + ",值:" + ee.getValue());
        });
    }
}
