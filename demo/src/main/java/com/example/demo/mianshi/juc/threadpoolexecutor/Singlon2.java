package com.example.demo.mianshi.juc.threadpoolexecutor;

/**
 * @description
 * @date 2023/4/15 08:57
 */

public class Singlon2 {

    private volatile static Singlon2 demo;

    private Singlon2() {
    }

    ;

    public static Singlon2 getInstance() {
        //第一个 if 语句用来避免 uniqueInstance 已经被实例化之后的加锁操作
        if (demo == null) {
            synchronized (Singlon2.class) {
                //第二个 if 语句进行了加锁，所以只能有一个线程进入，就不会出现 instance == null 时两个线程同时进行实例化操作。
                if (demo == null) {
                    demo = new Singlon2();
                    return demo;
                }
            }
        }
        return demo;
    }
}
