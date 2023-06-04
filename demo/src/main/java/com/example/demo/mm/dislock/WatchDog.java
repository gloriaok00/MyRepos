package com.example.demo.mm.dislock;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @description 当一个线程获取到锁并开始执行任务时，
 * 如果任务执行时间超过了锁的持有时间（默认为30秒），
 * Watch Dog会自动发送续约请求给Redisson，延长锁的有效期。
 * 可以在执行了这个方法之后，在redis客户端里ttl 这个key，可以看到续命的过程
 * @date 2023/6/4 17:59
 */

public class WatchDog {

    public static void main(String[] args) {
        // 创建 Redisson 客户端连接
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379");
        RedissonClient redisson = Redisson.create(config);

        // 获取分布式锁
        RLock lock = redisson.getLock("lock");

        // 加锁并执行任务
        lock.lock();
        try {
            System.out.println("获取到锁，开始执行任务");
            Thread.sleep(30000); // 模拟长时间执行任务
            System.out.println("任务执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 手动释放锁
            lock.unlock();
            System.out.println("释放锁");
        }

        // 关闭 Redisson 客户端连接
        redisson.shutdown();
    }

}
