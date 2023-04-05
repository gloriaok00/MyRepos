package com.example.demo.mm.thread.manyget;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description 异步获取不同时长的结果
 * @date 2023/2/21 10:06
 */

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        List<RestResult<Integer>> list = new ArrayList<>();
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService pool = Executors.newFixedThreadPool(3);
        WorkThread w1 = new WorkThread(1000, "线程1", latch, list);
        WorkThread w2 = new WorkThread(2000, "线程2", latch, list);
        WorkThread w3 = new WorkThread(3000, "线程3", latch, list);
        pool.submit(w1);
        pool.submit(w2);
        pool.submit(w3);
        latch.await();
        System.out.println("主线程已取回所有结果");
        for (RestResult<Integer> temp : list) {
            System.out.println("结果:" + temp.getData());
        }
        pool.shutdown();
    }
}


