package com.example.demo.pingshi.mythread.t14;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description atomic学习
 * @date 2023/1/26 17:19
 */

public class T14 {

    static AtomicInteger atomic = new AtomicInteger(0);

    @SneakyThrows
    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            int i = 1;
            while (i <= 10) {
                atomic.incrementAndGet();
                i++;
            }
        });
        t.start();
        int i = 1;
        while (i <= 10) {
            atomic.incrementAndGet();
            i++;
        }
        t.join();
        System.out.println("两个线程同时改一个变量:" + atomic.get());
    }
}
