package com.example.demo.mianshi.juc.locks;

/**
 * @author zhangyu
 * @date 2019-09-11 18:31
 * 可重入锁synchronized
 */

class Phone {

    public synchronized void sendMsg() {
        System.out.println(Thread.currentThread().getName() + " implements sendMsg");
        sendEmail();
    }

    public void sendEmail() {
        System.out.println(Thread.currentThread().getName() + " implements sendEmail");
    }
}

public class KeChongRuLock {

    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendMsg();
        }, "t1").start();

        new Thread(() -> {
            phone.sendMsg();
        }, "t2").start();
    }
}
