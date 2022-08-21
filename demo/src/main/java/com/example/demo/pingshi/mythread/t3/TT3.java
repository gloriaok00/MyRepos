package com.example.demo.pingshi.mythread.t3;

import org.junit.Test;

/**
 * @description 随机练习
 * @date 2022/8/18 11:48
 */

public class TT3 {

    class ThreadRunner implements Runnable{
        @Override
        public void run() {
            System.out.println("dfdsf");
        }
    }

    @Test
    public void show() {
        Runnable runner=new Runnable() {
            @Override
            public void run() {
                System.out.println("dfsdfdf");
            }
        };
        Thread t1=new Thread(runner);
        Thread t2=new Thread(new ThreadRunner());
        Thread t3=new Thread(runner);
        System.out.println(t1.getName());
        System.out.println(Thread.currentThread().getName());
        System.out.println(t2.getName());
        System.out.println(t3.getName());

        Thread t4=new Thread();
        t4.run();

        Thread t = new Thread() {
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.print(i + " ");
                }
            }
        };
        t.start();

        Thread t1111 = new Thread(()->{
            for (int i = 1; i <= 5; i++) {
                System.out.print(i + " ");
            }
        });
    }
}
