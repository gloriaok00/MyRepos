package com.example.demo.pingshi.mythread.t15;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  @description FixedPool搭配的是无界阻塞队列
 *  @date  2023/2/2 06:45
 */
public class FixedPool {
    public static void main(String[] args) {
        //线程池大小为3，然后在线程池提交了5个任务。在提交第4个任务时，因为线程池的大小已经达到了3并且前3个任务在运行中，
        //所以第4个任务被放入了队列，等待有空闲的线程时再被运行。运行结果如下（注意前3个任务和后2个任务的运行时间）
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat(
                                "HH:mm:ss");
                        System.out.println("运行时间: " +
                                sdf.format(new Date()) + " " + index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        fixedThreadPool.shutdown();
    }
}
