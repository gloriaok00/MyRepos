package com.example.demo.pingshi.mymap;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @description 模拟正在遍历 然后删除了集合中的元素 抛异常的情况
 * @date 2023/1/31 15:19
 */

public class MyCount {

    public static void main(String[] args) {
        //启始数据准备
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            list.add(i);
        }
        System.out.println(list.size());
        CyclicBarrier barrier = new CyclicBarrier(2, new ALLAction());
        Executor executor = Executors.newFixedThreadPool(2);

        //遍历
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (Integer temp : list) {
                    if (temp == 699) {
                        try {
                            barrier.await();
                        } catch (InterruptedException | BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                    }else{
                        System.out.println(temp);
                    }
                }
            }
        };

        //删除
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    barrier.await();
                    list.remove(700);
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
