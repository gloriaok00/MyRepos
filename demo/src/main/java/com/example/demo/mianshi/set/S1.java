package com.example.demo.mianshi.set;

import java.util.HashSet;

/**
 * @description set随机练习
 * @date 2022/6/13 12:41
 */

public class S1 {

    public static void main(String[] args) {
        HashSet set=new HashSet();
        set.add("a");
        set.add("b");
        System.out.println(set.remove("a"));
        System.out.println(set.remove("c"));
    }

}
