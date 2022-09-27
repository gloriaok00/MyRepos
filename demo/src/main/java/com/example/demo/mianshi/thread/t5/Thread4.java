package com.example.demo.mianshi.thread.t5;

import lombok.SneakyThrows;

/**
 * @description
 * @date 2022/9/27 10:06
 */

public class Thread4 {

    @SneakyThrows
    public static void main(String[] args) {
        Runnable r = () -> {
            int n = 0;
            while (!Thread.currentThread().isInterrupted()) {
                n++;
                System.out.println("hello," + n);
            }
        };
        Thread t=new Thread(r);
        t.start();
        Thread.sleep(100);
        t.interrupt();
    }
}
