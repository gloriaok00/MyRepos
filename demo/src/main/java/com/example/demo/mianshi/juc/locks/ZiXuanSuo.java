package com.example.demo.mianshi.juc.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zhangyu
 * @date 2019-09-13 13:31
 */

public class ZiXuanSuo {

    AtomicReference<Thread> atomicReference = new AtomicReference<Thread>();

    public void getMylock() {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread + "coming");
        while (!atomicReference.compareAndSet(null, currentThread)) {
            //System.out.println(currentThread.getName()+"试图抢锁");
        }
    }

    public void unlockMylock() {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread + "unlock");
        atomicReference.compareAndSet(currentThread, null);
    }

    public static void main(String[] args) {
        ZiXuanSuo demo = new ZiXuanSuo();
        new Thread(() -> {
            demo.getMylock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ;
            demo.unlockMylock();
        }, "t5").start();

        try {
            //Time.sleep(1);
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            demo.getMylock();
            demo.unlockMylock();
        }, "t6").start();
    }
}
