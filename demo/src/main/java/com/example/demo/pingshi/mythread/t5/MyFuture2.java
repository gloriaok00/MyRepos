package com.example.demo.pingshi.mythread.t5;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @description
 * @date 2022/9/11 22:42
 */

public class MyFuture2 {

    @Test
    public void test1() throws Exception {

        System.out.println("main函数开始执行");

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                System.out.println("===task start===");
                Thread.sleep(5000);
                System.out.println("===task finish===");
                return 3;
            }
        });
        //精髓:这里需要返回值时会阻塞主线程，如果不需要返回值使用是OK的。倒也还能接收
        //Integer result=future.get();
        System.out.println("main函数执行结束");

        System.in.read();

    }

}
