package com.example.demo.mianshi.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangyu
 * @date 2019-09-08 12:15
 */
public class MyAtomicInteger {
    public static void main(String[] args) {

        /**
         * 这个就是关于integer
         */
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1023) + "\t" + atomicInteger.get());
    }
}
