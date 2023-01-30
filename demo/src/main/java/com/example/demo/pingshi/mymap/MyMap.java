package com.example.demo.pingshi.mymap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description 随机练习
 * @date 2023/1/30 08:23
 */

public class MyMap {

    static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 10000; i++) {
            map.put(i, i);
        }
        System.out.println(map.size());
        //遍历
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                }
            }
        };
        Thread t1 = new Thread(r1);


        //删除
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 7330; i <= 10000; i++) {
                    map.remove(i);
                }
            }
        };
        Thread t = new Thread(r);
        //同时启动两者
        t1.start();
        t.start();

        //等待两个子线程执行完毕
        t1.join();
        t.join();

        System.out.println("main ends");
    }
}
