package com.example.demo.pingshi.mythread.t7;

/**
 * @description 再学习
 * @date 2022/6/19 13:04
 * @date 2022/9/25 22:48
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadWaitNotify {

    public static void main(String[] args) throws InterruptedException {
        //创建一个线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建DemoTest对象
        DemoTest demoTest = new DemoTest();
        //用线程池创建线程异步执行waitTest方法
        executorService.submit(() -> demoTest.waitTest());
        //用线程池创建线程异步执行notifyTest方法
        executorService.submit(() -> demoTest.notifyTest());
    }

    //测试wait和notify测试demo
    static class DemoTest {
        //唤醒线程
        public synchronized void notifyTest() {
            System.out.println("2");
            notify();
            System.out.println("3");
            System.out.println("但会继续执行完自己锁内的代码之后，才会交出锁的控制权。");
            System.out.println("https://blog.csdn.net/x541211190/article/details/109258676");
        }

        //执行wait操作将线程挂起，注意必须结合synchronized使用
        public synchronized void waitTest() {
            System.out.println("1");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("4");
        }
    }
}
