package com.example.demo.pingshi.mythread.t18;

import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.concurrent.*;

/**
 * @description newScheduledThreadPool练习
 * @date 2023/2/6 12:17
 */
@Slf4j
public class SchedulePool {

    public static void main(String[] args) {
        log.info("准备执行任务");
        Queue<String> queue = new ConcurrentLinkedDeque<>();
        queue.add("1号");
        queue.add("2号");
        queue.add("15号");
        queue.add("7号");
        queue.add("17号");

        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        for (int i = 0; i < queue.size(); i++) {
            ScheduledFuture<String> future = pool.schedule(new Callable<String>() {
                @Override
                public String call() throws InterruptedException {
                    log.info(Thread.currentThread().getName() + " " + System.currentTimeMillis() + "当前执行的任务是" + queue.poll());
                    //TimeUnit.SECONDS.sleep(2);
                    return "callSchedule";
                }
            }, 5, TimeUnit.SECONDS);
        }
    }
}
