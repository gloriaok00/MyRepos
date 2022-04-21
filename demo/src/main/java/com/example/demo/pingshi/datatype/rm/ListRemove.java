package com.example.demo.pingshi.datatype.rm;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @description list remove学习 arrays.asList
 * @date 2022-04-20 18:03
 */

public class ListRemove {

    public static void main(String[] args) {
        String pattern = " ^, v, m, n-music-name, $ ";
        String[] patternSplit = pattern.split(",");

        // 去除模式中的^和$标识
        //想起来了 Arrays.asList 里调的是AbstractList里的remove方法会报UnsupportedOperationException
        List<String> natureList = Arrays.asList(patternSplit);
        List<String> newCopylist=Lists.newCopyOnWriteArrayList(natureList);
        //natureList.forEach(System.out::println);
        newCopylist.add("add和remove都行了");
        //System.out.println();
        newCopylist.forEach(System.out::println);

    }
}
