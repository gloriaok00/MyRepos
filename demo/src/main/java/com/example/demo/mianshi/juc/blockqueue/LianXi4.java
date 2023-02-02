package com.example.demo.mianshi.juc.blockqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LianXi4 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 20; i++) {
            executorService.execute(new MyRunnable(i));
        }
    }
}

class MyRunnable implements Runnable {
    int id;

    MyRunnable(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("threadPool task id:" + id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
