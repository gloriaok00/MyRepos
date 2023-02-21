package com.example.demo.mm.thread.comser;

import lombok.AllArgsConstructor;

import java.util.concurrent.Callable;

/**
 * @description
 * @date 2023/2/21 16:52
 */

@AllArgsConstructor
public class WorkThread implements Callable<String> {

    private String name;

    @Override
    public String call() throws Exception {
        for (int i = 1; i < 10000; i++) {
Thread.sleep(1);
        }
        return name + "执行完毕";
    }
}

@AllArgsConstructor
class WorkThread1 implements Callable<String> {

    private String name;

    @Override
    public String call() throws Exception {
        return name + "执行完毕";
    }
}
