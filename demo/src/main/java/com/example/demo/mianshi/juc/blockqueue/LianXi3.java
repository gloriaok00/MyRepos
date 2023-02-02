package com.example.demo.mianshi.juc.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description 随机练习 模拟消费大于生产的情况
 * @date 2023/2/2 10:39
 */

public class LianXi3 {

    public static void main(String[] args) throws InterruptedException {
        int size = 200000;
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(size);
        ExecutorService consumer = Executors.newFixedThreadPool(5);
        ExecutorService producer = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 100000; i++) {
            queue.add(i);
        }
        consumer.submit(new Runnable() {
            @Override
            public void run() {
                while (queue.size() > 0) {
                    try {
                        //消费的快 生产的慢
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    queue.poll();
                    System.out.println("消费了1个");
                }
            }
        });
        producer.submit(new Runnable() {
            @Override
            public void run() {
                AtomicInteger atomic = new AtomicInteger();
                while (true) {
                    try {
                        //消费的快 生产的慢
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    queue.add(atomic.incrementAndGet());
                    System.out.println("生产了1个");
                }
            }
        });
        while(true){
            Thread.sleep(5000);
            System.out.println("当前数量:"+queue.size());
        }
    }
}
