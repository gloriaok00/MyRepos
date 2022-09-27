package com.example.demo.mianshi.thread.t4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description
 * @date 2022/9/27 09:35
 */

public class SinglePool {

    public static void main(String[] args) {
        Runnable r1 = () -> {
            System.out.println("1");
        };
        Runnable r2 = () -> {
            System.out.println("2");
        };
        Runnable r3 = () -> {
            System.out.println("3");
        };
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(r1);
        executor.submit(r2);
        executor.submit(r3);
        executor.shutdown();
    }
}
