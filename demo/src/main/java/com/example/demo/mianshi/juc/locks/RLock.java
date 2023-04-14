package com.example.demo.mianshi.juc.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description lock练习
 * @date 2023/4/14 10:30
 */

public class RLock {

    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        RLock rLock = new RLock();
        for (int i = 1; i < 11; i++) {
            rLock.nonSta();
        }
    }

    public void nonSta() {
        new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread() + "我抢到了");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                lock.unlock();
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread() + "我完事了");
            lock.unlock();
        }).start();
    }

}
