package com.example.demo.mm.dislock;

import org.redisson.Redisson;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 *  @description  为啥一直拿不到锁呢
 *  @date  2023/3/7 17:16
 */
public class RedLockDemo {

    private static final String resourceName = "REDLOCK";
    private static RedissonClient cli_79;
    private static RedissonClient cli_89;
    private static RedissonClient cli_99;

    static {
        Config config_79 = new Config();
        config_79.useSingleServer()
                .setAddress("redis://127.0.0.1:7000") // 注意这里我的Redis测试实例没密码
                .setDatabase(0);
        cli_79 = Redisson.create(config_79);

        Config config_89 = new Config();
        config_89.useSingleServer()
                .setAddress("redis://127.0.0.1:7001")
                .setDatabase(0);
        cli_89 = Redisson.create(config_89);

        Config config_99 = new Config();
        config_99.useSingleServer()
                .setAddress("redis://127.0.0.1:7002")
                .setDatabase(0);
        cli_99 = Redisson.create(config_99);
    }
    /**
     * 加锁操作
     */
    private static void lock () {

        // 向3个Redis实例尝试加锁
        RLock lock_79 = cli_79.getLock(resourceName);
        RLock lock_89 = cli_89.getLock("k2");
        RLock lock_99 = cli_99.getLock("k3");
        RedissonRedLock redLock = new RedissonRedLock(lock_79, lock_89, lock_99);

        try {
            boolean isLock = redLock.tryLock(5, 10, TimeUnit.SECONDS);
            System.out.println("xx:"+isLock);
            if (isLock) {
                // do something ...
                System.out.println(Thread.currentThread().getName() + "Get Lock Success!");
                TimeUnit.MILLISECONDS.sleep(30000);
            } else {
                System.out.println(Thread.currentThread().getName() + "Get Lock fail!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 无论如何一定要释放锁 -> 这里会像所有的Redis服务释放锁
            redLock.unlock();
        }
    }
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> lock()).start();
        }

    }

}
