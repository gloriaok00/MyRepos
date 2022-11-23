package com.example.demo.pingshi.mylist;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description flatMap随机练习
 * @date 2022/11/23 17:48
 */

public class LL3 {

    @Test
    @SneakyThrows
    public void xxx() {
        String[] s1 = {"我"};
        List<String> one = Arrays.asList(s1);
        String[] s2 = {"爱"};
        List<String> two = Arrays.asList(s2);
        String[] s3 = {"你"};
        List<String> three = Arrays.asList(s3);

        Stream.of(one, two, three).flatMap(Collection::stream).collect(Collectors.toList()).forEach(System.out::println);

    }

    @Test
    public void sss() {
        //快速实例化int数组
        int[] a1 = {1, 2, 4};
        int[] a2 = IntStream.of(1, 2, 3, 4).toArray();
        System.out.println(Arrays.toString(a2));
    }

    @Test
    public void zzz() {
        List<String> strs = Arrays.asList("好,好,学", "习,天,天", "向,上");

        List<String[]> strArray = strs.stream().map(str -> str.split(",")).collect(Collectors.toList());
        System.out.println(strArray);
        System.out.println("===========");
        List<String> strArray11 = strs.stream().map(str -> str.split(",")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(strArray11);
    }

    @Test
    public void mmm() {
        List<String> pp = new ArrayList<>();
        pp.add("qq");
        pp.add("qq1");
        pp.add("qq2");
        String[] ll=new String[3];
        //注意list.toArray(数组类型)
        System.out.println(Arrays.toString(pp.toArray(ll)));
    }

}
