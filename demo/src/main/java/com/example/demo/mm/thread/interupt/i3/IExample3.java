package com.example.demo.mm.thread.interupt.i3;

public class IExample3 extends Thread {

    volatile boolean stop = false;

    public static void main(String args[]) throws Exception {
        
        IExample3 thread = new IExample3();

        System.out.println("Starting thread...");
        thread.start();

        Thread.sleep(3000);

        System.out.println("Asking thread to stop...");

        thread.stop = true;

        thread.interrupt();

        Thread.sleep(3000);
        System.out.println("Stopping application...");
        System.exit(0);
    }

    public void run() {
        while (!stop) {
            System.out.println("Thread running...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // 接收到一个中断异常（InterruptedException），从而提早地终结被阻塞状态
                System.out.println("Thread interrupted...");
            }
        }

        System.out.println("Thread exiting under request...");
    }
}
