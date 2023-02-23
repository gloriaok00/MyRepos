package com.example.demo.mm.thread.cas.c1;

import com.example.demo.mm.thread.cas.c1.Account;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @description 随机练习
 * @date 2023/2/23 14:28
 */

public class Main {

    Account account = new Account();

    @Test
    public void init() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(3);

        Runnable r1 = () -> {
            account.deposit(100);
            account.withdraw(90);
            latch.countDown();
        };
        Runnable r2 = () -> {
            account.deposit(20);
            account.withdraw(5);
            latch.countDown();
        };
        Runnable r3 = () -> {
            account.deposit(100);
            account.withdraw(5);
            latch.countDown();
        };

        pool.submit(r1);
        pool.submit(r2);
        pool.submit(r3);
        latch.await();
        System.out.println(account.getBalance());
        pool.shutdown();

    }
}
