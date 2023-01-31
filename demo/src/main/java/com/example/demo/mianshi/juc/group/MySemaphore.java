package com.example.demo.mianshi.juc.group;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *  @description 6辆车抢3个车位
 *  @date 2019-09-14 16:22
 *  @date 2023/1/31 13:16
 */
public class MySemaphore {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            final int temp = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("第" + temp + "个车占了车位");
                    TimeUnit.MILLISECONDS.sleep(3);
                    System.out.println("第" + temp + "个车停车3豪钟结束");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, "").start();
        }
    }
}
