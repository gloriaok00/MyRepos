package com.example.demo.mianshi.juc.blockqueue.type;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author zhangyu
 * @date 2019-09-15 10:42
 * @description SynchronousQueue
 */
public class MyConcurrentLinkedQueue {

    public static void main(String[] args) {

        //由于本身ConcurrentLinkedQueue是无界的 所以add与offer是一样的 因为不会出现无法放入而报错的情况
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        //本身这些添加的方法是用了CAS的手法
        queue.add(1);
        queue.offer(2);

    }
}
