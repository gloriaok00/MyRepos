package com.example.demo.mianshi.juc.volatiles;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangyu
 * @description volatile 可见性
 * @date 2020-04-08 10:03
 */
@Slf4j
public class VolatileDemo {

    public static void main(String[] args) {
        MyData myData = new MyData();

        //A线程
        new Thread(() -> {
            log.info(Thread.currentThread().getName() + "进入");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            myData.shutDownRequested = true;
            log.info("A线程修改shutDownRequested变量值完成{}", myData.shutDownRequested);
        }, "A线程").start();

        //主线程
        while (myData.shutDownRequested == false) {
            //

        }
        log.info(Thread.currentThread().getName() + "里shutDownRequested的值为{}", myData.shutDownRequested);
    }
}

class MyData {
    volatile boolean shutDownRequested = false;
}
