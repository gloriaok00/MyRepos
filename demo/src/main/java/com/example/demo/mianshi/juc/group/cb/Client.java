package com.example.demo.mianshi.juc.group.cb;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @description CyclicBarrier练习
 * @date 2023/1/31 14:33
 */
public class Client {

    public static void main(String[] args) throws Exception {
        //第二个参数的意思是都达到条件后 要执行的东西
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new TourGuideTask());
        Executor executor = Executors.newFixedThreadPool(3);
        //登哥最大牌，到的最晚
        executor.execute(new TravelTask(cyclicBarrier, "哈登", 5));
        executor.execute(new TravelTask(cyclicBarrier, "保罗", 3));
        executor.execute(new TravelTask(cyclicBarrier, "戈登", 1));

    }
}
