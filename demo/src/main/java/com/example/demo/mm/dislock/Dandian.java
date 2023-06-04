package com.example.demo.mm.dislock;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * @description 单点分布式锁
 * @date 2023/6/3 22:08
 */
public class Dandian implements Runnable {

    private Config config = new Config();
    private RLock lock = null;
    private RedissonClient redisson = null;

    public void init() {
        // 创建 Redisson 客户端连接
        config.useSingleServer().setAddress("redis://localhost:6379");
        redisson = Redisson.create(config);
        // 获取分布式锁
        lock = redisson.getLock("myLock");
    }

    @Override
    public void run() {
        try {
            // 尝试加锁，等待时间为10秒，锁持有时间为60秒
            boolean isLocked = lock.tryLock(10, 60, TimeUnit.SECONDS);
            while (!isLocked) {
                // 没抢着锁，就歇一会，然后继续抢
                System.out.println(Thread.currentThread().getId() + "没抢着锁，就歇一会，然后继续抢");
                Thread.sleep(100);
            }
            // 成功获取到锁
            System.out.println(Thread.currentThread().getId() + "抢到锁了，模拟执行业务逻辑...");
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getId()+"成功执行完了，准备释放锁");
        } catch (InterruptedException e) {
            // 锁获取过程中被中断
            System.out.println("获取锁过程中被中断");
        } finally {
            // 释放锁
            System.out.println(Thread.currentThread().getId()+"释放锁了");
            lock.unlock();
        }

        // 关闭 Redisson 客户端连接
        //redisson.shutdown();
    }

    public static void main(String[] args) {
        Dandian t1=new Dandian();
        t1.init();
        System.out.println("开始抢锁：");
        for (int i = 0; i < 30; i++) {
            new Thread(t1).start();
        }

    }
}
