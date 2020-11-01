package com.example.demo.mianshi.juc.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyu
 * @date 2019-09-14 17:05
 * @desprition ArrayBlockingQueue
 */
public class MyArrayBlockingQueue {

    public static void main(String[] args) {
        ArrayBlockingQueue arrayQueue = new ArrayBlockingQueue(3);
        System.out.println(arrayQueue.add(1));
        System.out.println(arrayQueue.add(2));
        System.out.println(arrayQueue.add(3));
        //System.out.println( arrayQueue.add(3));//抛异常，超出空间
        System.out.println(arrayQueue.offer(33));//不抛异常，返回false

        System.out.println(arrayQueue.element());//显示队头的元素

        System.out.println(arrayQueue.remove());
        System.out.println(arrayQueue.remove());
        System.out.println(arrayQueue.remove());
        //System.out.println(arrayQueue.remove());//抛异常，没有元素了
        System.out.println(arrayQueue.poll());//不抛异常，返回NULL

        try {
            arrayQueue.put("a");
            arrayQueue.put("b");
            arrayQueue.put("c");
            arrayQueue.put("c");//会阻塞，直到成功
        } catch (Exception e) {
            e.printStackTrace();
        }

        try{
            arrayQueue.offer("d",2L, TimeUnit.SECONDS);//只阻塞2秒钟，如果在该期限内没成功，就返回false
            arrayQueue.poll(2L,TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
