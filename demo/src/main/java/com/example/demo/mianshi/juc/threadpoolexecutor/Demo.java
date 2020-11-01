package com.example.demo.mianshi.juc.threadpoolexecutor;

import java.util.concurrent.*;

/**
 * @author zhangyu
 * @date 2019-09-15 17:19
 */
public class Demo {
    public static void main(String[] args) {
        //ExecutorService pool= Executors.newFixedThreadPool(5);
        //ExecutorService pool= Executors.newSingleThreadExecutor();
        //ExecutorService pool= Executors.newCachedThreadPool();
        ExecutorService pool=new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        try{
            for (int i = 1; i <=100 ; i++) {
                final int temp=i;
                pool.execute(new Thread(()->{
                    Thread currentThread=Thread.currentThread();
                    System.out.println("第"+temp+"位客户正在用第"+currentThread+"个窗口办理业务");
                }));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            pool.shutdown();
        }
    }
}
