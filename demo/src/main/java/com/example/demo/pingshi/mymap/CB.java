package com.example.demo.pingshi.mymap;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @description 再体会CyclicBarrier
 * @date 2023/1/31 16:42
 */

public class CB {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(2, new ALLAction());
        Executor executor = Executors.newFixedThreadPool(2);

        //遍历
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我是r1我来了");
                try {
                    barrier.await();
                    System.out.println("r1在总的之后继续了...");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        };

        //删除
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("我是r我来了");
                try {
                    barrier.await();
                    System.out.println("r在总的之后继续了...");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        };
        executor.execute(r1);
        executor.execute(r);

        System.out.println("main ends");
    }
}
