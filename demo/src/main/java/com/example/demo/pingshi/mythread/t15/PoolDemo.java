package com.example.demo.pingshi.mythread.t15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description newCachedThreadPool练习 非常好的例子
 * https://blog.csdn.net/w605283073/article/details/90735382
 * @date 2023/2/6 07:41
 */
public class PoolDemo {

    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    private static final AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            //Thread.sleep(100L);
            executorService.submit(PoolDemo::print);
        }
    }

    public static void print() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(atomicInteger.incrementAndGet());
    }

}
