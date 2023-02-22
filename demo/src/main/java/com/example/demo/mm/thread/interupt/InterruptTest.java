package com.example.demo.mm.thread.interupt;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *  @description
 *  @date  2023/2/22 09:37
 */
public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        executor.execute(new Task("0"));
        Thread.sleep(1);
        executor.shutdownNow();
        System.out.println("executor has been shutdown");
    }

    static class Task implements Runnable {
        String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {

            for (int i = 1; i <= 100 && !Thread.interrupted(); i++) {
                Thread.yield();
                System.out.println("task " + name + " is running, round " + i);
            }

        }
    }
}
