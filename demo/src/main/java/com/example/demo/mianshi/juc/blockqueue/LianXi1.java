package com.example.demo.mianshi.juc.blockqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangyu
 * @date 2019-09-15 11:38
 */

class SharedData {
    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increase() throws Exception {
        try {
            lock.lock();
            //判断
            while (number != 0) {
                //等待，不能生产
                condition.await();
            }
            //生产
            number++;
            System.out.println(Thread.currentThread().getName() + "生产了1个");
            //通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrease() throws Exception {
        try {
            lock.lock();
            //判断
            while (number == 0) {
                //等待，不能消耗
                condition.await();
            }
            //生产
            number--;
            System.out.println(Thread.currentThread().getName() + "消耗了1个");
            //通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class LianXi1 {

    public static void main(String[] args) {
        SharedData data = new SharedData();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    data.increase();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AAA").start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    data.decrease();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BBB").start();
    }
}
