package com.example.demo.pingshi.mythread.t4.lianxi;

/**
 * @description
 * @date 2022/8/30 15:10
 */

public class TL1 {

    public static void main(String[] args) throws InterruptedException {
        Long s1 = System.currentTimeMillis();
        System.out.println("====主线程开始:" + s1);
        Thread ss = new Thread(() -> {
            Long s3 = System.currentTimeMillis();
            System.out.println("====子线程开始:" + s3);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Long s4 = System.currentTimeMillis();
            System.out.println("====子线程结束:" + s4);
            System.out.println("子线程执行时间:" + (s4 - s3));
        });
        ss.start();
        Long s2 = System.currentTimeMillis();
        System.out.println("====主线程结束:" + s2);
        System.out.println("主线程执行时间:" + (s2 - s1));
    }
}
