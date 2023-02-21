package com.example.demo.mm.thread.manyget;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;

/**
 * @description 异步获取不同时长的结果
 * @date 2023/2/21 10:06
 */

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        List<RestResult<Integer>> vector = new Vector();
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService pool = Executors.newFixedThreadPool(3);
        WorkThread w1 = new WorkThread(1000, "线程1", latch, vector);
        WorkThread w2 = new WorkThread(2000, "线程2", latch, vector);
        WorkThread w3 = new WorkThread(3000, "线程3", latch, vector);
        pool.submit(w1);
        pool.submit(w2);
        pool.submit(w3);
        latch.await();
        System.out.println("主线程已取回所有结果");
        for (RestResult<Integer> temp : vector) {
            System.out.println("结果:" + temp.getData());
        }
    }
}


