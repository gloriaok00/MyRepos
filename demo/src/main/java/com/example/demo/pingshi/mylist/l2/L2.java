package com.example.demo.pingshi.mylist.l2;

import java.util.ArrayList;
import java.util.List;

/**
 * @description ArrayList add添加时的不安全情况模拟
 * @date 2022/12/21 23:43
 */

public class L2 {

    public static void main(String[] args) throws InterruptedException {

        final List<Integer> list = new ArrayList<>();

        // 线程A将0-10000添加到list
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    list.add(i);

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // 线程B将10000-20000添加到列表
        new Thread(new Runnable() {
            public void run() {
                for (int i = 10000; i < 20000; i++) {
                    list.add(i);

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Thread.sleep(1000);

        // 打印所有结果
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "个元素为：" + list.get(i));
        }
    }
}
