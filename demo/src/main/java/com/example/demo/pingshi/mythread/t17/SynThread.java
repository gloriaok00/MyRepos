package com.example.demo.pingshi.mythread.t17;

/**
 * @description 这就是同步的
 * @date 2023/2/3 14:04
 */

public class SynThread {

    public static void main(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 10000; i++) {
                    System.out.println(i);
                }
            }
        };
        r.run();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 10000; i <= 20000; i++) {
                    System.out.println(i);
                }
            }
        };
        r1.run();
    }
}
