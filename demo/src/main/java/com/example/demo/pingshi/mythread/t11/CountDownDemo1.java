package com.example.demo.pingshi.mythread.t11;

import java.util.concurrent.CountDownLatch;

/**
 * @description 闭锁练习
 * @date 2023/1/31 10:41
 */
public class CountDownDemo1 {

    public static void main(String[] args) throws Exception {
        int sum = 5;
        CountDownLatch latch = new CountDownLatch(sum);
        mainWork();
        for (int i = 1; i <= sum; i++) {
            Runnable r = () -> {
                try {
                    Thread.sleep((long) Math.floor(Math.random() * 10000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                }
            };
            r.run();
        }
        latch.await();
        System.out.println("main ends!!");

    }

    private static void mainWork() {
        System.out.println("Main thread start work!");
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread work done!");
    }
}
