package com.example.demo.pingshi.mythread.t15;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @description iterator remove用不了
 * @date 2023/2/3 13:32
 */

public class IteratorDemo {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        //iterator的remove方法也是直接抛出异常
        Iterator<Integer> iterator = set.iterator();
        iterator.remove();
    }
}
