package com.example.demo.pingshi.mythread.t11;

import java.util.concurrent.CountDownLatch;

public class CountDownDemo {

    public static void main(String[] args) throws Exception {
        //定义线程数
        int subThreadNum = 5;
        //取得一个倒计时器，从5开始
        CountDownLatch countDownLatch = new CountDownLatch(subThreadNum);
        //依次创建5个线程，并启动
        for (int i = 0; i < subThreadNum; i++) {
            new SubThread(2000*(i+1), countDownLatch).start();
        }
        //主线程工作
        mainWork();
        //等待所有的子线程结束
        countDownLatch.await();
        System.out.println("Main Done!");
    }
    private static void mainWork(){
        System.out.println("Main thread start work!");
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Main Thread work done!");
    }
    /**
     * 子线程类
     * @author fuhg
     */
    private static class SubThread extends Thread{

        private CountDownLatch countDownLatch;
        private long workTime;

        public SubThread(long workTime,CountDownLatch countDownLatch){
            this.workTime = workTime;
            this.countDownLatch = countDownLatch;
        }

        public void run() {
            // TODO Auto-generated method stub
            try {
                System.out.println("Sub thread is starting!");
                Thread.sleep(workTime);
                System.out.println("Sub thread is stopping!");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                //线程结束时，将计时器减一
                countDownLatch.countDown();
            }
        }
    }
}
