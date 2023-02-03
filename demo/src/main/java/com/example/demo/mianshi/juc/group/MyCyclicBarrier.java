package com.example.demo.mianshi.juc.group;

import java.util.concurrent.CyclicBarrier;


/**
 * @description 刚来北京时的理解 不深刻
 * @date 2023/2/3 11:42
 * @date 2019-09-14 15:22
 */
public class MyCyclicBarrier {

    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙成功");
        });

        for (int i = 1; i < 8; i++) {
            final int temp = i;
            new Thread(() -> {
                System.out.println("搜集神龙" + temp + "成功");
                try {
                    cyclicBarrier.await();
                    System.out.println(temp + "在总的完事后继续运行");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
