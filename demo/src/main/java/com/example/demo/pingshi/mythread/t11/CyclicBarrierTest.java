package com.example.demo.pingshi.mythread.t11;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("5个用户开始抽奖" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for(int i = 0; i < 5; i ++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " 用户开始抽奖，持续"+(index+1)+"秒" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
                    try {
                        Thread.sleep((index + 1) * 1000);
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println("所有用户抽奖完毕，颁发奖项。为用户" + Thread.currentThread().getName() + "颁奖。" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
                }
            }, "Thread-" + i).start();
        }
        Thread.sleep(5000l);
        System.out.println("下一轮抽奖开始" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        for(int i = 0; i < 5; i ++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " 用户开始抽奖，持续"+(index+1)+"秒" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
                    try {
                        Thread.sleep((index + 1) * 1000);
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println("所有用户抽奖完毕，颁发奖项。为用户" + Thread.currentThread().getName() + "颁奖。" + DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
                }
            }, "Thread-" + i).start();
        }
    }

}
