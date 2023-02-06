package com.example.demo.mianshi.juc.blockqueue.type;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * @description 随机练习
 * @date 2023/2/6 12:52
 */

public class SynQueue {

    public static void main(String[] args) {

        Queue<Integer> queue = new SynchronousQueue<>();
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
        //想模拟出消耗和添加同时跑的情况 只能用newCachedThreadPool了。因为用newFixedThreadPool要是参数给1，只有添加在跑。当参数给2时就OK了
        //用newSingleThreadExecutor也是嘛。只有一个任务在跑
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.submit(r);
        pool.submit(r1);
    }
}
