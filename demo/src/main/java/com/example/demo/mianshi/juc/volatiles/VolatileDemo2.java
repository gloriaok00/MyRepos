package com.example.demo.mianshi.juc.volatiles;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangyu
 * @description volatile原子性
 * @date 2020-04-08 12:39
 */
@Slf4j
public class VolatileDemo2 {

    public static void main(String[] args) {
        Data myData = new Data();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    myData.k++;
                }
            }, "线程" + i).start();
        }

        //主线程
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        log.info(Thread.currentThread().getName() + "里k的值为{}", myData.k);
    }
}

class Data {
    volatile int k = 0;
}
