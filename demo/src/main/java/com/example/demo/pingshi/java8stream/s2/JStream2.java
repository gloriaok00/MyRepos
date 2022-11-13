package com.example.demo.pingshi.java8stream.s2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @description 随机练习
 * @date 2022/11/13 19:17
 */

public class JStream2 {

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<Integer> l2 = Arrays.asList(3, 2, 3);
        List<Integer> l3 = Arrays.asList(1, 3, 3);
        JStream2 mm = new JStream2();
        System.out.println(mm.add(l1, l2, l3));
    }

    public List<Integer> add(List<Integer>... lists) {
        List<Integer> result = IntStream.range(0, lists[0].size()).map(i -> {
            int xx = 0;
            for (int j = 0; j < lists.length; j++) {
                xx = lists[j].get(i) + xx;
            }
            return xx;
        }).boxed().collect(Collectors.toList());
        return result;
    }
}
