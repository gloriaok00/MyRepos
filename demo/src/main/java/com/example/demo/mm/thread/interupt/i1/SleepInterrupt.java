package com.example.demo.mm.thread.interupt.i1;


/**
 * @description 等待状态下 调interrupt会抛异常 交给业务处理
 * @date 2023/2/22 10:51
 */

public class SleepInterrupt {

    public static void main(String[] args) {

        Thread xx = new Thread1();
        xx.start();
        while (true) {
            System.out.println(2);
            xx.interrupt();
        }

    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("1");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("抛出异常");
            }
        }
    }
}
