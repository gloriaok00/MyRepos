package com.example.demo.pingshi.java8stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangyu
 * @date 2019/12/11 10:46
 */
public class Demo33 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa bbb ccc");
        list.add("ddd eee fff");
        list.add("ggg hhh iii");

        list.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList()).forEach(e-> System.out.println(e));

    }
}
