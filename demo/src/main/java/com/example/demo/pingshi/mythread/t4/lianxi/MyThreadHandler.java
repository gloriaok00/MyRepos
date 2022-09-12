package com.example.demo.pingshi.mythread.t4.lianxi;

/**
 * @description
 * @date 2022/8/30 16:17
 */

public class MyThreadHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("捕获到了线程中抛出的异常" + t.getName());
    }
}
