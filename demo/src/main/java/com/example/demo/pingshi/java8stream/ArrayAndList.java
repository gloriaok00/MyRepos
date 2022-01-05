package com.example.demo.pingshi.java8stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangyu
 * @date 2019/12/9 18:08
 */
public class ArrayAndList {

    public static void main(String[] args) {

        //数组转list
        String[] strArrays = new String[]{"a", "b", "c"};
        Arrays.stream(strArrays).collect(Collectors.toList()).forEach(e -> System.out.println(e));
        Arrays.asList(strArrays).forEach(e -> System.out.println(e));

        //list转数组
        String[] arrays = new String[]{"a", "b", "c"};
        List<String> myList = Arrays.asList(arrays);
        String[] returnedArray = myList.stream().toArray(String[]::new);
        for (String s : returnedArray) {
            System.out.println(s);
        }
    }
}
