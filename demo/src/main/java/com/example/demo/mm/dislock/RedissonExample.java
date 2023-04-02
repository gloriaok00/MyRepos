package com.example.demo.mm.dislock;

import lombok.SneakyThrows;
import org.redisson.Redisson;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.CountDownLatch;

/**
 *  @description 本个线程同时给一个值增加数量。redis单线程
 *  @date  2023/4/2 17:36
 */

public class RedissonExample implements Runnable{

    CountDownLatch latch=new CountDownLatch(3);
    Config config;
    RedissonClient redisson;
    RAtomicLong counter;

    public RedissonExample() {
        this.config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        this.redisson = Redisson.create(config);
        this.counter = redisson.getAtomicLong("count3");
    }

    @SneakyThrows
    public static void main(String[] args) {
       RedissonExample example=new RedissonExample();
        example.counter.set(1);
        Thread t1=new Thread(example);
        Thread t2=new Thread(example);
        Thread t3=new Thread(example);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        // 打印递增后的计数器值
        System.out.println("Counter value: " + example.counter.get());

        // 关闭Redisson客户端连接
        example.redisson.shutdown();
    }

    @Override
    public void run() {
        // 将计数器增加100下
        for (int i = 1; i <= 99; i++) {
            counter.incrementAndGet();
        }
    }
}
