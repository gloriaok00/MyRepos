package com.example.demo.pingshi.mythread.t4.lianxi;

import org.junit.Test;

/**
 * @description
 * @date 2022/8/30 16:16
 */

public class TL2 {

    @Test
    public void mm() {
        Thread t1 = new Thread(() -> {
            System.out.println("抛异常");
            throw new RuntimeException();
        });
        //UncaughtExceptionHandler能在线程外处理异常的手段
        t1.setUncaughtExceptionHandler(new MyThreadHandler());
        t1.start();
    }
}
