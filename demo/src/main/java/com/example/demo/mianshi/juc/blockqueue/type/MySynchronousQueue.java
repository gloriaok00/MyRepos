package com.example.demo.mianshi.juc.blockqueue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyu
 * @date 2019-09-15 10:42
 * @description SynchronousQueue
 */
public class MySynchronousQueue {
    public static void main(String[] args) {

        SynchronousQueue<String> syncQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println("放A");
                syncQueue.put("A");
                System.out.println("放B");
                syncQueue.put("B");
                System.out.println("放C");
                syncQueue.put("C");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "AAA").start();

        new Thread(() -> {
            try {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(syncQueue.take() + "放出去了");

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (Exception ee) {
                    ee.printStackTrace();
                }

                System.out.println(syncQueue.take() + "放出去了");

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                System.out.println(syncQueue.take() + "放出去了");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "BBB").start();
    }
}
