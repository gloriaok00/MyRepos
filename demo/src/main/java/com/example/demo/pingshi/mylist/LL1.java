package com.example.demo.pingshi.mylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description list与array转化再学习
 * @date 2022/11/19 02:05
 */

public class LL1 {

    public static void main(String[] args) {
        //zzz
        List<String> list = new ArrayList() {{
            add("a");
            add("b");
            add("c");
        }};
        //aaa
        List<String> list1 = new ArrayList<>();
        list1.add("张三");
        list1.add("李四");
        //String[] strings1 = (String[]) list1.toArray();//会报错 java.lang.ClassCastException: java.lang.Object[] cannot be cast to java.lang.String[]
        String[] s2 = list1.toArray(new String[list1.size()]);//最佳解决方式
        System.out.println("cc:" + s2[1]);

        //bb
        Object[] cc = list1.toArray();
        System.out.println("mm:" + cc[0]);

        //cc
        List<String> ll = new ArrayList<>(Arrays.asList(s2));
        System.out.println(ll);
    }
}
