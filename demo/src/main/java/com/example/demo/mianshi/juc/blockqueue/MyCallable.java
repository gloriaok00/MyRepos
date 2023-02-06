package com.example.demo.mianshi.juc.blockqueue;

import java.util.concurrent.*;

/**
 *  @description 改旧东西
 *  @date  2019-09-15 15:34
 *  @date  2023/2/7 06:10
 */
public class MyCallable {

    public static void main(String[] args) throws Exception {
        Callable<Integer> task =new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("callable方法..");
                return 101;
            }
        };
        ExecutorService pool=Executors.newSingleThreadExecutor();
        Future<Integer> result1=pool.submit(task);
        int result2 = 100;
        System.out.println(result1.get() + result2);
        pool.shutdown();
    }

}
