package com.example.demo.pingshi.mythread.t18;

import io.netty.util.concurrent.DefaultThreadFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @description newScheduledThreadPool练习
 * @date 2023/2/6 12:17
 */
@Slf4j
public class SchedulePoolDemo {

    public static void main(String[] args) {
        log.info("准备执行任务");
        List<String> list = new ArrayList<>();
        list.add("1号");
        list.add("2号");
        list.add("5号");
        list.add("7号");
        list.add("9号");
        list.add("10号");
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1,
                new DefaultThreadFactory("schedule"));

        for (String task : list) {
            pool.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    log.info("线程 {} " + " 当前执行的任务是 {}", Thread.currentThread().getName(), task);
                }
            }, 3, 5, TimeUnit.SECONDS);
        }
    }
}
