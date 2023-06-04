package com.example.demo.mm.dislock;

import lombok.SneakyThrows;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @description 单点分布式锁
 * @date 2023/6/3 22:08
 */
public class Dandian implements Runnable {

    private Config config = new Config();
    private RLock lock = null;
    RedissonClient redisson = null;
    CountDownLatch latch;
    String mid;

    public Dandian(String mid, int count) {
        this.mid = mid;
        latch = new CountDownLatch(count);
    }

    public void init() {
        // 创建 Redisson 客户端连接
        config.useSingleServer().setAddress("redis://localhost:6379");
        redisson = Redisson.create(config);
        // 获取分布式锁
        lock = redisson.getLock("myLock");
    }

    @Override
    public void run() {
        String id = Thread.currentThread().getName();
        String idStr = mid + id + "，";
        try {
            // 尝试加锁
            System.out.println(idStr + "准备抢锁");
            boolean isLocked = lock.tryLock(1, 6, TimeUnit.SECONDS);
            while (!isLocked) {
                // 没抢着锁，就歇一会，然后继续抢
                System.out.println(idStr + "没抢着锁，就歇一会，然后继续抢");
                Thread.sleep(50);
                isLocked = lock.tryLock(1, 6, TimeUnit.SECONDS);
            }
            // 成功获取到锁
            System.out.println(idStr + "抢到锁了，模拟执行业务逻辑...");
            Thread.sleep(500);
            System.out.println(idStr + "成功执行完了，准备释放锁");
            latch.countDown();
        } catch (InterruptedException e) {
            // 锁获取过程中被中断
            System.out.println("获取锁过程中被中断");
        } finally {
            // 释放锁
            System.out.println(idStr + "释放锁了");
            lock.unlock();
        }

    }

    @SneakyThrows
    public static void main(String[] args) {
        int count = 20;
        Dandian t1 = new Dandian("1号机器", count);
        t1.init();
        System.out.println("开始抢锁：");
        for (int i = 0; i < count; i++) {
            Thread t = new Thread(t1);
            t.setName(String.valueOf(i));
            t.start();
        }
        t1.latch.await();
        System.out.println(t1.mid + "全部执行结束，关闭redisson客户端");
        // 关闭 Redisson 客户端连接
        t1.redisson.shutdown();
    }

    //模拟多个机器上一起抢
    @SneakyThrows
    public void begin(CountDownLatch latch1) {
        int count = 20;
        Dandian t1 = new Dandian(mid, count);
        t1.init();
        System.out.println("开始抢锁：");
        for (int i = 0; i < count; i++) {
            Thread t = new Thread(t1);
            t.setName(String.valueOf(i));
            t.start();
        }
        t1.latch.await();
        System.out.println(t1.mid + "全部执行结束，关闭redisson客户端");
        // 关闭 Redisson 客户端连接
        t1.redisson.shutdown();
        latch1.countDown();
    }
}
