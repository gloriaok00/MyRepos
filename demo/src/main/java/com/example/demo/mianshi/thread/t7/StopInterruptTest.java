package com.example.demo.mianshi.thread.t7;

import lombok.SneakyThrows;

public class StopInterruptTest {
    private int i = 0;

    @SneakyThrows
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int i=0;
            // 中断标志判断
            while (i==5) {
                i++;
                System.out.println(i);
                if(i==5){
                    System.out.println("Dfsdfsdf");
                    Thread.currentThread().interrupt();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // 重置标志位
                    //Thread.currentThread().isInterrupted();
                }
            }
            System.out.println("dfdsf");
        });

        t1.start();
        Thread.sleep(10);
        // main线程打断线程t1
        t1.interrupt();
    }

    public void addI() {


            i++;
            System.out.println(i);

    }
}
