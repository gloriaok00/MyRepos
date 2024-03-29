package com.example.demo.mianshi.thread.t16;

/**
 * @description
 * @date 2023/1/24 19:54
 */

public class T16 {

    // 创建资源
    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 创建线程
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                // 获取resourceA共享资源的监视器锁
                synchronized (resourceA) {
                    try {
                        System.out.println("threadA begin wait");
                        resourceA.wait();
                        System.out.println("threadA end wait");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });
        // 创建线程
        Thread threadB = new Thread(new Runnable() {
            public void run() {
                synchronized (resourceA) {
                    try {
                        System.out.println("threadB begin wait");
                        resourceA.wait();
                        System.out.println("threadB end wait");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });
        // 创建线程
        Thread threadC = new Thread(new Runnable() {
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadC begin");
                    //resourceA.notify();
                    resourceA.notifyAll();
                }
            }
        });
        // 启动线程
        threadA.start();
        threadB.start();
        Thread.sleep(1000);
        threadC.start();
        // 等待线程结束
        threadA.join();
        threadB.join();
        threadC.join();
        System.out.println("main over");
    }
}
