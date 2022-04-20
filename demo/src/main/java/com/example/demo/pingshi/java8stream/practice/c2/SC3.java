package com.example.demo.pingshi.java8stream.practice.c2;

import java.util.Arrays;
import java.util.List;

/**
 * @description
 * @date 2022-04-20 17:17
 */

public class SC3 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream().forEach(System.out::println);
        System.out.println();
        numbers.parallelStream().forEachOrdered(System.out::println);
    }
}
