package com.example.demo.mianshi.juc.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 *  @description lock练习
 *  @date  2023/4/14 12:28
 */
public class ReentrantLockCountExample {

    private static volatile int count = 0;
    static ReentrantLock lock = new ReentrantLock();

    public static void countHandler() {
        lock.lock();
        System.out.println(Thread.currentThread() + "抢到了");
        try {
            count++;
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread() + "我完事了");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        int threads = 5;
        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
                countHandler();
            }).start();
        }
    }

}
