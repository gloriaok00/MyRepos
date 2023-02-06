package com.example.demo.pingshi.mythread.t18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description
 * @date 2023/2/6 11:16
 */

public class CachePool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; i <= 20; i++) {
            executorService.execute(new rr(i));
        }
    }
}
