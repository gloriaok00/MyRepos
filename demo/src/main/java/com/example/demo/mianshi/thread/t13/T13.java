package com.example.demo.mianshi.thread.t13;

import java.util.LinkedList;

/**
 * @description
 * @date 2023/1/24 17:21
 */

public class T13 {

    public static void main(String[] args) {

        LinkedList<Integer> queue = new LinkedList<>();
        int MAX_SIZE = 10;

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //生产线程
                    synchronized (queue) {
                        //消费队列满，则等待队列空闲
                        while (queue.size() == MAX_SIZE) {
                            try {
                                System.out.println("当前生产的已经满了...释放锁，进行等待..");
                                queue.wait();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                        //空闲则生成元素，并通知消费者线程
                        queue.add(1);
                        System.out.println("生产了1个..");
                        queue.notifyAll();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //消费者线程
                    synchronized (queue) {
                        //消费队列为空
                        while (queue.size() == 0) {
                            try {
                                System.out.println("当前队列里没有元素..挂起..等待中..");
                                queue.wait();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                        //消费元素，并通知唤醒生产者线程
                        queue.remove();
                        System.out.println("消费了1个..");
                        queue.notifyAll();
                    }
                }
            }
        }).start();
    }
}

