package com.example.demo.pingshi.mythread.t18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description 固定的练习
 * @date 2023/2/6 11:08
 */

public class FixPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 20; i++) {
            executorService.execute(new rr(i));
        }
    }

}


class rr implements Runnable {
    int id;

    rr(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
