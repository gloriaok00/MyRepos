package com.example.demo.pingshi.mythread.t16;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description put才是会阻塞的方法 存在于BlockingQueue接口
 * @date 2023/2/3 14:04
 */

public class ArrayBlockQueueTest {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);
        for (int i = 1; i <= 10; i++) {
            queue.offer(i);
        }
        System.out.println("offer后的size:" + queue.size());
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                    queue.poll();
                    System.out.println("清除了一个");
                    Thread.sleep(1000);
                    queue.poll();
                    System.out.println("又清除了一个");
                    Thread.sleep(2000);
                    queue.poll();
                    System.out.println("再清除了一个");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ExecutorService e = Executors.newFixedThreadPool(1);
        e.submit(r);

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 11; i <= 110; i++) {
                    //当达到最大容量后再放就被阻塞了
                    try {
                        queue.put(i);
                        System.out.println("添加了一个");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //由于被阻塞了 所以这句没显示出来
                System.out.println("put后的size:" + queue.size());
            }
        };
        ExecutorService e1 = Executors.newFixedThreadPool(1);
        e1.submit(r1);
    }
}
