package com.example.demo.pingshi.mythread.t19;

import java.util.concurrent.*;

/**
 * @description CompletionService的作用就是谁有了谁就返回，
 * 不是等全部都齐了后 才返回
 * @date 2023/2/7 20:26
 */
public class CompletionServiceTest {

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(pool);
        Callable<Integer> c = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                return 1;
            }
        };
        Callable<Integer> c1 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 2;
            }
        };
        Callable<Integer> c2 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(500);
                return 3;
            }
        };
        completionService.submit(c);
        completionService.submit(c1);
        completionService.submit(c2);
        System.out.println("after submit");
        for (int i = 0; i < 3; i++) {
            System.out.println("result: " + completionService.take().get()); // 这个方法是阻塞的
        }
        System.out.println("after get");
        pool.shutdown();
    }

}
