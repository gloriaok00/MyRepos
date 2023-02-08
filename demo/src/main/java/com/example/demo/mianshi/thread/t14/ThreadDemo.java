package com.example.demo.mianshi.thread.t14;

/**
 *  @description 想明白了 线程就是异步的啊 那个Runnable的本身就是执行接口嘛 所以才是同步执行的
 *  @date  2023/2/8 09:50
 */

public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println("---begin---");
                    Thread.sleep(2000);
                    System.out.println("---end---");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        System.out.println("---begin interrupt threadA---");
        System.out.println("---end interrupt threadA---");
    }
}
