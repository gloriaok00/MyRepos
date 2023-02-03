package com.example.demo.mianshi.juc.group;

import java.util.concurrent.CountDownLatch;

/**
 *  @description 刚来北京时的理解 不深刻
 *  @date  2023/2/3 11:44
 *  @date  2019-09-14 14:06
 */
public class MyCountDownLatch {
    public static void main(String[] args) throws Exception {
        CountDownLatch mylatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                mylatch.countDown();
                System.out.println("第" + temp + "位同学离开了教室");
            }, String.valueOf(temp)).start();
        }
        mylatch.await();
        System.out.println(Thread.currentThread() + "班长锁上门");
    }
}
