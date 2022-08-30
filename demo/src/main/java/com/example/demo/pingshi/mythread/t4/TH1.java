package com.example.demo.pingshi.mythread.t4;

/**
 * @description
 * @date 2022/8/30 14:11
 */

public class TH1 {

    public static void main(String[] args) throws Exception{
        Long s1=System.currentTimeMillis();
        System.out.println("主线程 =====> 开始 =====> " + s1);

        new Thread(() -> {
            System.out.println("异步线程 =====> 开始 =====> " + System.currentTimeMillis());
            try{
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("异步线程 =====> 结束 =====> " + System.currentTimeMillis());
        }).start();

        Thread.sleep(2000);
        Long s2=System.currentTimeMillis();
        System.out.println("主线程 =====> 结束 =====> " + s2);

        System.out.println(s2 - s1);
    }
}
