package com.example.demo.mianshi.juc.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *  @description  ArrayBlockingQueue发生阻塞示例
 *  @date  2023/4/5 17:46
 */
public class ArrayBlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个容量为2的 ArrayBlockingQueue
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

        // 启动一个生产者线程，往队列中不断添加元素
        Thread producerThread = new Thread(() -> {
            try {
                queue.put(1);
                System.out.println("生产者线程添加元素1");
                queue.put(2);
                System.out.println("生产者线程添加元素2");
                queue.put(3); // 尝试添加第3个元素，会被阻塞
                System.out.println("生产者线程添加元素3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 启动一个消费者线程，从队列中不断获取元素
        Thread consumerThread = new Thread(() -> {
            try {
                Thread.sleep(1000); // 等待1秒钟，让生产者线程先执行
                System.out.println("消费者线程获取元素1次：" + queue.take());
                System.out.println("消费者线程获取元素2次：" + queue.take());
                System.out.println("消费者线程获取元素3次：" + queue.take()); // 尝试获取第4个元素，会被阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();

        // 等待线程执行完成
        producerThread.join();
        consumerThread.join();
    }
}
