package com.example.demo.mianshi.map.m1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @description  随机练习
 * @date 2022/6/12 21:11
 */

public class M1 {

    public static void main(String[] args) throws InterruptedException {
        //线程安全的Map
        Map map = Collections.synchronizedMap(new HashMap());
        //线程不安全
        //Map map = new HashMap();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 100001; i++) {
                    map.put(i,i);
                }
            }
        });
        t1.start();

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 100001; i < 200001; i++) {
                    map.put(i,i);
                }
            }
        });
        t2.start();
        try {
            // 等待两个线程都运行结束后，再打印结果
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(map.size());
    }

}
