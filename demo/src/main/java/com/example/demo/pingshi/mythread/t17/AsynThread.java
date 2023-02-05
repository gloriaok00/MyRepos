package com.example.demo.pingshi.mythread.t17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description 这就是异步的
 * @date 2023/2/3 14:04
 */

public class AsynThread {

    public static void main(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 10000; i++) {
                    System.out.println(i);
                }
            }
        };
        ExecutorService e = Executors.newFixedThreadPool(1);
        e.submit(r);
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 10000; i <= 20000; i++) {
                    System.out.println(i);
                }
            }
        };
        ExecutorService e1 = Executors.newFixedThreadPool(1);
        e1.submit(r1);

    }
}
