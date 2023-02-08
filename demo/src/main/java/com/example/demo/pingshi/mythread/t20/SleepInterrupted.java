package com.example.demo.pingshi.mythread.t20;

/**
 * @description interrupt再理解
 * @date 2023/2/8 10:00
 */

public class SleepInterrupted {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("ffff");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("状态:" + Thread.currentThread().isInterrupted());
                }
            }
        };
        Thread t1 = new Thread(r);
        t1.start();
        System.out.println("begin interrupt");
        t1.interrupt();
        System.out.println("end interrupt");

    }
}
