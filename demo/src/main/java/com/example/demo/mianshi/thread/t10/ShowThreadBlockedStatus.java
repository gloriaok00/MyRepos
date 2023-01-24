package com.example.demo.mianshi.thread.t10;
/**
 *  @description 日常练习
 *  @date  2023/1/24 21:11
 */

public class ShowThreadBlockedStatus implements Runnable {
    final Object obj = new Object();

    public static void main(String[] args) {
        ShowThreadBlockedStatus runnable = new ShowThreadBlockedStatus();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //线程1的状态:TIMED_WAITING,因为：Thread.sleep(1000)
        System.out.println("线程1的状态:" + thread1.getState());
        // 打印出BLOCKED，因为拿不到method的方法锁
        System.out.println("线程2的状态:" + thread2.getState());
    }

    @Override
    public void run() {
        synchronized (obj) {
            try {
                //System.out.println(Thread.currentThread().getName() + ",状态是：" + Thread.currentThread().getState());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
