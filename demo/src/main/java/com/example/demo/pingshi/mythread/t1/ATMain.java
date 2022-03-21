package com.example.demo.pingshi.mythread.t1;

/**
 * @description
 * @date 2022-03-21 10:42
 */

public class ATMain {

    public static void main(String[] args) {

        System.out.println("起始线程1:"+Thread.currentThread().getName());


        // 创建线程1, 使用默认线程名
        AsyncThread asyncThread1 = new AsyncThread();
        asyncThread1.setName("asyncThread1");

        // 创建线程2, 并设置名称
        AsyncThread asyncThread2 = new AsyncThread();
        asyncThread2.setName("asyncThread2");

        // 启动异步线程
        asyncThread1.start();
        asyncThread2.start();

        System.out.println("起始线程2:"+Thread.currentThread().getName());
    }

}
