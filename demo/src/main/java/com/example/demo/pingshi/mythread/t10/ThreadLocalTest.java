package com.example.demo.pingshi.mythread.t10;

/**
 * @description
 * @date 2023/1/25 18:02
 */

public class ThreadLocalTest {

    //(2) 创建ThreadLocal变量
    static ThreadLocal<Integer> local = new ThreadLocal<>();

    public static void main(String[] args) {
        //(3) 创建线程one
        Thread threadOne = new Thread(new Runnable() {
            public void run() {
                //3.1 设置线程One中本地变量localVariable的值
                local.set(1);
                local.set(11);
                //3.3 打印本地变量值
                System.out.println("threadOne remove after" + ":" + local.get());
            }
        });
        //(4) 创建线程two
        Thread threadTwo = new Thread(new Runnable() {
            public void run() {
                //4.1 设置线程Two中本地变量localVariable的值
                local.set(2);
                //4.3 打印本地变量值
                System.out.println("threadTwo remove after" + ":" + local.get());
            }
        });
        //(5)启动线程
        threadOne.start();
        threadTwo.start();
    }
}
