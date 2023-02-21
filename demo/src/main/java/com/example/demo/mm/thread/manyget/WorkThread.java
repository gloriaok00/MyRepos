package com.example.demo.mm.thread.manyget;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @description 模拟工作线程
 * @date 2023/2/21 14:26
 */

@AllArgsConstructor
public class WorkThread extends Thread{
    private int sleepTime;
    private String threadName;
    private CountDownLatch latch;
    private List<RestResult<Integer>> vector;

    @Override
    public void run() {
        try {
            Thread.sleep(sleepTime);
            int number = Integer.parseInt(threadName.substring(2));
            vector.add(new RestResult<>(number, 200, "成功"));
            System.out.println(threadName + "已返回结果");
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
