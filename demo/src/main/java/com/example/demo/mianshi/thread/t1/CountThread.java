package com.example.demo.mianshi.thread.t1;

/**
 * @description 多线程练习
 * @date 2022/6/9 20:45
 */

public class CountThread implements Runnable{

    //加volatile就安全了
    private static volatile int count=0;

    @Override
    public void run() {
        for (int k = 0; k < 10000; k++) {
            count++;
        }
    }

    public static void main(String[] args) {
        CountThread countThread=new CountThread();
        Thread t1=new Thread(countThread);
        Thread t2=new Thread(countThread);
        t1.start();
        t2.start();

        try {
            // 等待两个线程都运行结束后，再打印结果
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
