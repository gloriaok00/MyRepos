package com.example.demo.mianshi.thread.t2;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Join01 implements Runnable {

    private String name;

    public Join01(String name) {
        this.name = name;
    }

    public void run() {
        System.out.printf("%s begins: %s\n", name, new Date());
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s has finished: %s\n", name, new Date());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Join01("One"));
        Thread thread2 = new Thread(new Join01("Two"));
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Main thread is finished");
    }

}
