package com.example.demo.mianshi.juc.blockqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LianXi5 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; i <= 200; i++) {
            executorService.execute(new MyRunnable(i));
        }
    }
}
