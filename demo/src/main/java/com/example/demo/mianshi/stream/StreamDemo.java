package com.example.demo.mianshi.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description  随机练习
 * @date 2019-08-22 12:56
 * @date 2022-04-25 00:07
 */
public class StreamDemo {
    public static void main(String[] args) {
        Stream s1 = Stream.of("herew", "kui", "laopo");
        List<String> myList = Arrays.asList("a", "hbb", "sdad");
        Stream s2 = myList.stream();
        IntStream.of(new int[]{2,3,4}).forEach(System.out::println);
        System.out.println();
        IntStream.range(3,8).forEach(System.out::println);
        System.out.println();
        int[] intArr = new int[]{1, 2, 3, 4, 5};
        System.out.println(IntStream.of(intArr).map(i -> i * 2).reduce(0, Integer::sum));
    }
}
