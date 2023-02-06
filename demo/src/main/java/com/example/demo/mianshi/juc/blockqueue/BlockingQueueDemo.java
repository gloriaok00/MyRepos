package com.example.demo.mianshi.juc.blockqueue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description 随机练习 之前19年的记录那是完全没有什么理解啊
 * @date 2019-09-15 10:42
 * @date 2023/2/6 12:36
 */

public class BlockingQueueDemo {

    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayBlockingQueue<>(10000);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        for (int i = 1; i <= 10000; i++) {
                            queue.offer(i);
                            System.out.println(Thread.currentThread() + "添加了一个");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        queue.poll();
                        System.out.println(Thread.currentThread() + "消耗了一个");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.submit(r);
        pool.submit(r1);
    }
}
