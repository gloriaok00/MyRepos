package com.example.demo.mm.dislock;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 *  @description 单点分布式锁
 *  @date  2023/6/3 22:08
 */
public class dandian {

    public static void main(String[] args) {
        // 创建 Redisson 客户端连接
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379");
        RedissonClient redisson = Redisson.create(config);

        // 获取分布式锁
        RLock lock = redisson.getLock("myLock");

        try {
            // 尝试加锁，等待时间为10秒，锁持有时间为60秒
            boolean isLocked = lock.tryLock(10, 60, TimeUnit.SECONDS);
            if (isLocked) {
                // 成功获取到锁
                System.out.println("执行业务逻辑...");
            } else {
                // 获取锁超时
                System.out.println("获取锁超时，无法执行业务逻辑");
            }
        } catch (InterruptedException e) {
            // 锁获取过程中被中断
            System.out.println("获取锁过程中被中断");
        } finally {
            // 释放锁
            lock.unlock();
        }

        // 关闭 Redisson 客户端连接
        redisson.shutdown();
    }
}
