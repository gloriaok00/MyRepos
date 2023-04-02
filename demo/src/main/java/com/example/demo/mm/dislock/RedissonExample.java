package com.example.demo.mm.dislock;
import org.redisson.Redisson;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 *  @description 两个线程同时给一个值增加数量。单线程
 *  @date  2023/4/2 17:36
 */

public class RedissonExample {
    public static void main(String[] args) {
        // 创建Redisson客户端连接
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redisson = Redisson.create(config);

        // 获取计数器对象，并设置初始值为1
        RAtomicLong counter = redisson.getAtomicLong("count");
        counter.set(1);

        // 将计数器值递增到100
        for (int i = 1; i <= 99; i++) {
            counter.incrementAndGet();
        }

        // 打印递增后的计数器值
        System.out.println("Counter value: " + counter.get());

        // 关闭Redisson客户端连接
        redisson.shutdown();
    }
}
