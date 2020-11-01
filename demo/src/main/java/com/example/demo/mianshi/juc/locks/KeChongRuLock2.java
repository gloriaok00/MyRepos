package com.example.demo.mianshi.juc.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangyu
 * @date 2019-09-12 12:09
 */
class Phone2 implements Runnable {
    ReentrantLock lock = new ReentrantLock();

    public void sendMsg() {
        lock.tryLock();
        try {
            System.out.println(Thread.currentThread().getName() + " implements send msg");
            sendPhone();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void sendPhone() {

        /*lock.tryLock();
        try {
            System.out.println(Thread.currentThread().getName() + " implements send phone");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }*/

        System.out.println(Thread.currentThread().getName() + " implements send phone");
    }

    @Override
    public void run() {
        this.sendMsg();
    }
}

public class KeChongRuLock2 {

    public static void main(String[] args) {
        Phone2 phone2=new Phone2();
        Thread t3 = new Thread(phone2, "t3");
        Thread t4 = new Thread(phone2, "t4");
        t3.start();
        t4.start();
    }




}
