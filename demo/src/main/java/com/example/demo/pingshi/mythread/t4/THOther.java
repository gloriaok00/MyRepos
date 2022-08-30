package com.example.demo.pingshi.mythread.t4;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2022/8/30 14:57
 */

@Component
public class THOther {

    @Async
    public void asyncThread() {
        System.out.println("异步线程 =====> 开始 =====> " + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("异步线程 =====> 结束 =====> " + System.currentTimeMillis());
    }
}
