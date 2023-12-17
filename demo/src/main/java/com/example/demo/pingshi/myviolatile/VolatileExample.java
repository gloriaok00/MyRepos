package com.example.demo.pingshi.myviolatile;

/**
 *  @description from chatgpt
 *  @date  2023/12/17 14:03
 */
public class VolatileExample {
    private static volatile boolean stopThread = false;

    public static void main(String[] args) {
        // 创建一个修改共享变量的线程
        Thread writerThread = new Thread(() -> {
            int count = 0;
            while (!stopThread) {
                // 修改共享变量
                count++;
            }
            System.out.println("Writer Thread: Stopping");
        });

        // 创建一个读取共享变量的线程
        Thread readerThread = new Thread(() -> {
            while (!stopThread) {
                System.out.println("2:"+System.nanoTime());
                // 读取共享变量
                System.out.println("Reader Thread: " + stopThread);
            }
        });

        // 启动线程
        writerThread.start();
        readerThread.start();

        // 让线程运行一段时间
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 将stopThread变量设置为true以停止线程
        stopThread = true;
        System.out.println("1:"+System.nanoTime());
        // 等待线程完成
        try {
            writerThread.join();
            readerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
