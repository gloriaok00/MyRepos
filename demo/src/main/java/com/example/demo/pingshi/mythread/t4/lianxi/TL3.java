package com.example.demo.pingshi.mythread.t4.lianxi;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @description
 * @date 2022/8/30 11:28
 */

public class TL3 {

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
        //这里要是不注释的话，相当于同步取回了
        //Integer result=future.get();
        System.out.println("main函数执行结束");
        executor.shutdown();

    }

}
