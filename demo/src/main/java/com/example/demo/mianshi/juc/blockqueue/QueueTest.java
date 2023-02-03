package com.example.demo.mianshi.juc.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @description queue add vs offer
 * 终于有时间把queue的api深入的看一下 也是现在学完了数据结构了后才有效果
 * @date 2023/2/3 10:16
 */

public class QueueTest {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        for (int i = 1; i <= 15; i++) {
            //add方法若超出数量后直接抛出异常
            //System.out.println(queue.add(i));
            //offer方法若超出数量后返回false
            System.out.println(queue.offer(i));
        }
        System.out.println(queue.size());
    }
}
