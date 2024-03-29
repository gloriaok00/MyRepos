package com.example.demo.mianshi.thread.t7;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *  @description notify唤醒顺序
 *  @date  2022/9/27 14:29
 */
public class NotifyTest{

    //等待列表, 用来记录等待的顺序
    private static List<String> waitList = new LinkedList<>();
    //唤醒列表, 用来唤醒的顺序
    private static List<String> notifyList = new LinkedList<>();

    private static Object lock = new Object();


    public static void main(String[] args) throws InterruptedException{

        //创建50个线程
        for(int i=0;i<50;i++){
            String threadName = Integer.toString(i);
            new Thread(() -> {
                synchronized (lock) {
                    String cthreadName = Thread.currentThread().getName();
                    System.out.println("线程 ["+cthreadName+"] 正在等待.");
                    waitList.add(cthreadName);
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程 ["+cthreadName+"] 被唤醒了.");
                    notifyList.add(cthreadName);
                }
            },threadName).start();

            TimeUnit.MILLISECONDS.sleep(50);
        }

        TimeUnit.SECONDS.sleep(1);

        for(int i=0;i<50;i++){
            synchronized (lock) {
                lock.notify();
            }
            TimeUnit.MILLISECONDS.sleep(10);
        }
        System.out.println("wait顺序:"+waitList.toString());
        System.out.println("唤醒顺序:"+notifyList.toString());
    }
}
