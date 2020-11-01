package com.example.demo.mianshi.juc.locks;

/**
 * @author zhangyu
 * @date 2019-09-17 23:48
 */
public class MyThread extends Thread {
    private static volatile int n = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            add();
            try {
                sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private static synchronized void add() {
        n++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threads[] = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread();
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join(); //等待该线程终止
        }
        System.out.println(" n= " + n);
    }
}