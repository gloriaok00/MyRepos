package com.example.demo.pingshi.mythread.t4.lianxi;

/**
 * @description
 * @date 2022/8/30 15:10
 */

public class T1 {

    public static void main(String[] args) {
        Long s1 = System.currentTimeMillis();
        System.out.println("====主线程开始:" + s1);
        Thread ss = new Thread(() -> {
            System.out.println("====子线程开始:" + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("====子线程结束:" + System.currentTimeMillis());
        });
        ss.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long s2 = System.currentTimeMillis();
        System.out.println("====主线程结束:" + s2);
        System.out.println(s2 - s1);
    }
}
