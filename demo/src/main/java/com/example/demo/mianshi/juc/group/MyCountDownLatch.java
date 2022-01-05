package com.example.demo.mianshi.juc.group;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhangyu
 * @date 2019-09-14 14:06
 * @despcrtion 减法
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
