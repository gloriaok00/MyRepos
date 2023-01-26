package com.example.demo.pingshi.mythread.t12;

import lombok.SneakyThrows;

/**
 *  @description
 *  @date  2023/1/26 08:16
 */

public class T12 {

    @SneakyThrows
    public static void main(String[] args) {
        Object obj = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    System.out.println("xx:"+Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                    System.out.println("kkk:"+Thread.currentThread().getState());
                    System.out.println("dfs");
                    return;
                }
            }
        });
        t1.start();
        System.out.println(t1.isInterrupted());

        t1.interrupt();
        System.out.println(t1.isInterrupted());

        Thread.sleep(1000);
        System.out.println("fsdfdsf");
        System.out.println(t1.isInterrupted());
        System.out.println(t1.getState());

    }
}
