package com.example.demo.mianshi.juc.blockqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangyu
 * @date 2019-09-15 13:58
 */

class SharedResource {
    private int number = 1;
    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public void print5() {
        try {
            lock.lock();
            //判断
            while (number != 1) {
                c1.await();
            }
            //干活
            number = 2;
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //通知
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        try {
            lock.lock();
            //判断
            while (number != 2) {
                c2.await();
            }
            //干活
            number = 3;
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //通知
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        try {
            lock.lock();
            //判断
            while (number != 3) {
                c3.await();
            }
            //干活
            number = 1;
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //通知
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class LianXi2 {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                sharedResource.print5();
            }, "A").start();
            new Thread(() -> {
                sharedResource.print10();
            }, "B").start();
            new Thread(() -> {
                sharedResource.print15();
            }, "C").start();
        }
    }
}
