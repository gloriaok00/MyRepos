package com.example.demo.mm.thread.interupt.i3;

/**
 *  @description
 *  @date  2023/2/22 14:38
 */
public class IExample extends Thread {

    volatile boolean stop = false;

    public static void main(String args[]) throws Exception {

        IExample thread = new IExample();

        System.out.println("Starting thread...");

        thread.start();

        Thread.sleep(3000);

        System.out.println("Asking thread to stop...");

        thread.interrupt();

        Thread.sleep(3000);
        System.out.println("Stopping application...");

    }

    public void run() {
        while (true) {
            System.out.println("Thread running...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // 接收到一个中断异常（InterruptedException），从而提早地终结被阻塞状态
                System.out.println("Thread interrupted...");
            }
        }
    }

}
