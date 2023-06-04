package com.example.demo.mm.dislock;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

/**
 * @description 模拟多个机器的抢分布式锁
 * @date 2023/6/4 15:26
 */
@RestController
public class MDisDemo {

    int count1=3;
    CountDownLatch latch=new CountDownLatch(count1);

    @SneakyThrows
    @GetMapping("/aa22")
    public void aaa() {
        int count = 20;
        Dandian t1 = new Dandian("1号机器", count);
        Dandian t2 = new Dandian("2号机器", count);
        Dandian t3 = new Dandian("3号机器", count);
        new Thread(()->{t1.begin(latch);}).start();
        new Thread(()->{t2.begin(latch);}).start();
        new Thread(()->{t3.begin(latch);}).start();
        latch.await();
        System.out.println(count1+"个机器全抢完了...");
    }
}
