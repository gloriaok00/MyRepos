package com.example.demo.pingshi.mythread.t4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description
 * @date 2022/8/30 14:18
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class TH3 {

    @Autowired
    public THOther thOther;

    @Test
    public void mainThread() throws Exception {
        Long s1=System.currentTimeMillis();
        System.out.println("主线程 =====> 开始 =====> " + s1);
        //当这个方法与调他的方法在同一个类时 此时异步就失效了 变成了同步
        //this.asyncThread();
        thOther.asyncThread();
        Thread.sleep(2000);
        Long s2=System.currentTimeMillis();
        System.out.println("主线程 =====> 结束 =====> " + s2);
        System.out.println(s2 - s1);
        Thread.sleep(4000); // 用于防止jvm停止，导致异步线程中断
    }

    //当这个方法与调他的方法在同一个类时 此时异步就失效了 变成了同步
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
