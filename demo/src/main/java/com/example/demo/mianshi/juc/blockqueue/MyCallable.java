package com.example.demo.mianshi.juc.blockqueue;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 *  @description 改旧东西
 *  @date  2019-09-15 15:34
 *  @date  2023/2/7 06:10
 */

class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("callable方法..");
        return 101;
    }
}

public class MyCallable {

    public static void main(String[] args) throws Exception {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        ExecutorService pool=Executors.newSingleThreadExecutor();
        pool.submit(futureTask);
        int result2 = 100;
        int result1 = futureTask.get();
        System.out.println(result1 + result2);
        pool.shutdown();
    }

}
