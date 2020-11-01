package com.example.demo.mianshi.juc.group;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyu
 * @date 2019-09-14 16:22
 * @descprition 3个车位，6辆车
 */
public class MySemaphore {

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);
        for (int i = 1; i < 6; i++) {
            final int temp=i;
            new Thread(()->{
                try{
                    semaphore.acquire();
                    System.out.println("第"+temp+"个车占了车位");
                    TimeUnit.MILLISECONDS.sleep(3);
                    System.out.println("第"+temp+"个车停车3秒钟结束");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },"").start();
        }
    }
}
