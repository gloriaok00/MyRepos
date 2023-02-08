package com.example.demo.mianshi.thread.t14;

/**
 * @description
 * @date 2023/1/24 18:33
 * @date 2023/2/8  09:56
 */

public class T14 {

    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("---begin---");
                    //阻塞当前线程
                    synchronized (obj) {
                        obj.wait();
                    }
                    System.out.println("---end---");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("清除打断状态后:"+Thread.currentThread().isInterrupted());
                }
            }
        });
        threadA.start();
        System.out.println("---begin interrupt threadA---");
        threadA.interrupt();
        System.out.println("---end interrupt threadA---");
    }
}
