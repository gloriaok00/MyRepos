package com.example.demo.mianshi.juc.blockqueue.type;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *  @description ArrayBlockingQueue之前的老东西重新认识一下
 *  @date  2019-09-14 17:05
 *  @date  2023/2/6 15:41
 */
public class MyArrayBlockingQueue {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> arrayQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayQueue.add(1));
        System.out.println(arrayQueue.add(2));
        System.out.println(arrayQueue.add(3));
        //System.out.println( arrayQueue.add(3));//抛异常，超出空间
        System.out.println(arrayQueue.offer(33));//不抛异常，返回false

        System.out.println("头元素:"+arrayQueue.element());//显示队头的元素

        System.out.println(arrayQueue.remove());
        System.out.println(arrayQueue.remove());
        System.out.println(arrayQueue.remove());
        //System.out.println(arrayQueue.remove());//抛异常，没有元素了
        System.out.println("空元素了:"+arrayQueue.poll());//不抛异常，返回NULL

        try {
            arrayQueue.put(12);
            arrayQueue.put(34);
            arrayQueue.put(566);
            //会阻塞，直到成功
            //arrayQueue.put(45);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(arrayQueue.offer(100, 2L, TimeUnit.SECONDS));//只阻塞2秒钟，如果在该期限内没成功，就返回false
            System.out.println(arrayQueue.poll(2L, TimeUnit.SECONDS));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
