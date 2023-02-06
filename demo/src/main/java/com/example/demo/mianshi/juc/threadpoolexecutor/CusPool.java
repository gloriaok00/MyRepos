package com.example.demo.mianshi.juc.threadpoolexecutor;

import java.util.concurrent.*;

/**
 *  @description 也是之前的东西 现在在练习
 *  @date  2019-09-15 17:19
 *  @date  2023/2/6 20:50
 */
public class CusPool {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(
                40,
                50,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(300),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        try {
            for (int i = 1; i <= 10000; i++) {
                final int temp = i;
                pool.execute(new Thread(() -> {
                    Thread currentThread = Thread.currentThread();
                    System.out.println("第" + temp + "位客户正在用第" + currentThread + "个窗口办理业务");
                }));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }
}
