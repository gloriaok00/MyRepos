package com.example.demo.pingshi.mythread.t13;

/**
 * @description
 * @date 2023/1/26 09:42
 */

public class T13 {

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("threadOne begin sleep for 2000 seconds");
                    Thread.sleep(2000000);
                    System.out.println("threadOne awaking");
                } catch (InterruptedException e) {
                    System.out.println("threadOne is interrupted while sleeping");
                    System.out.println("xxL:"+Thread.currentThread().getState());
                    return;
                }
                System.out.println("threadOne-leaving normally");
            }
        });
        //启动线程
        threadOne.start();
        //确保子线程进入休眠状态
        Thread.sleep(1000);
        //打断子线程的休眠，让子线程从sleep函数返回
        threadOne.interrupt();
        System.out.println("oooL:"+threadOne.getState());
        //等待子线程执行完毕
        threadOne.join();
        System.out.println("oooL11:"+threadOne.getState());
        System.out.println("main thread is over");
    }}
