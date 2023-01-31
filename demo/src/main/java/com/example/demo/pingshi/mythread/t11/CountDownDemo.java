package com.example.demo.pingshi.mythread.t11;

import java.util.concurrent.CountDownLatch;

public class CountDownDemo {

    public static void main(String[] args) throws Exception {
        int sum = 5;
        CountDownLatch latch = new CountDownLatch(sum);
        Long time = 3000L;
        System.out.println("main keeping..");
        mainWork();
        for (int i = 0; i < sum; i++) {
            Thread xx=new SubThread(time, latch);
            xx.start();
        }
        latch.await();
        System.out.println("main ends");

    }

    private static void mainWork() {
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
     */
    private static class SubThread extends Thread {

        private CountDownLatch countDownLatch;
        private long workTime;

        public SubThread(long workTime, CountDownLatch countDownLatch) {
            this.workTime = workTime;
            this.countDownLatch = countDownLatch;
        }

        public void run() {
            // TODO Auto-generated method stub
            try {
                System.out.println("Sub thread is starting!");
                countDownLatch.countDown();
                Thread.sleep(workTime);
                System.out.println("Sub thread is stopping!");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
