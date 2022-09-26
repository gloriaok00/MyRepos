package com.example.demo.mianshi.thread.t2;

/**
 *  @description  wait的例子
 *  @date  2022/9/26 23:35
 */
public class WaitTest {

    private synchronized void count(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if(i == 5){
                try {
                    System.out.println("进入 wait 状态...");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitTest waitTest = new WaitTest();

        //TODO 没明白这种写法
        new Thread(waitTest::count).start();

        Thread.sleep(2000);

        synchronized (waitTest){
            System.out.println("唤醒线程...");
            waitTest.notifyAll();
        }
    }

}
