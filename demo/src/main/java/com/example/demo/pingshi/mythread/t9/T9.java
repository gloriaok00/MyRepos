package com.example.demo.pingshi.mythread.t9;

/**
 * @description 测试没拿到相应的锁却去做wait操作
 * @date 2023/1/25 09:40
 */

public class T9 {

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (obj1) {
                try {
                    obj2.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
    }
}
