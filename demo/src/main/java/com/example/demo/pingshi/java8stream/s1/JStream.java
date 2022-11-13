package com.example.demo.pingshi.java8stream.s1;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @description 生成多个随机数
 * @date 2022/11/13 13:30
 */

public class JStream {

    public static void main(String[] args) {
        Random random = new Random();
        IntStream intStream = random.ints(500, 1000);
        List<Integer> mm=intStream.limit(100).boxed().collect(Collectors.toList());
        System.out.println(mm);
    }
}
