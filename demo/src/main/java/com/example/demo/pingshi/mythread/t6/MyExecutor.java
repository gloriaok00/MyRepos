package com.example.demo.pingshi.mythread.t6;

import com.example.demo.mianshi.cas.User;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @description Executor相关api学习
 * @date 2022/9/11 21:49
 */

public class MyExecutor {

    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println("无返回值");
        };
        Executors.newFixedThreadPool(1).submit(r);
        Callable<User> c = () -> {
            System.out.println("有返回值");
            return new User("test", 10);
        };
        FutureTask<User> f = new FutureTask<>(c);
        Executors.newFixedThreadPool(1).submit(f);
    }
}
