package com.example.demo.mm.thread.interupt.i4;

import java.util.concurrent.TimeUnit;

public class Test06 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("线程一正在执行，将进入等待状态，时间= " + System.currentTimeMillis() + ",中断标志位：" + Thread.currentThread().isInterrupted());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("1");
            }
            System.out.println("线程一从等待状态中醒来，时间= " + System.currentTimeMillis() + ",中断标志位：" + Thread.currentThread().isInterrupted());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("2");
            }
            System.out.println("线程一从等待状态中醒来，时间= " + System.currentTimeMillis() + ",中断标志位：" + Thread.currentThread().isInterrupted());
        });

        System.out.println("主线程正在执行");
        thread.start();
        System.out.println("主线程等待，睡眠两秒");
        TimeUnit.SECONDS.sleep(2);
        thread.interrupt();
    }
}
/*
执行结果：
主线程正在执行
主线程等待，睡眠两秒
线程一正在执行，将进入等待状态，时间= 1592272574294,中断标志位：false
线程一从等待状态中醒来，时间= 1592272576295,中断标志位：false
线程一从等待状态中醒来，时间= 1592272581295,中断标志位：false
*/
