package com.example.demo.mianshi.list.l2;

import java.util.*;

/**
 * @description 随机练习
 * @date 2022/6/4 23:41
 */

public class ListTwo {

    public static void main(String[] args) {

        //collection类的实例化接受以collection为类型的去初始化
        String[] array = {"xczc", "juddf", "juddf", "sd"};
        Set<String> set = new HashSet<>(Arrays.asList(array));
        System.out.println(set.size());
        List<String> list = new ArrayList<>(set);
        list.forEach(System.out::println);
    }
}
