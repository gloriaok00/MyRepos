package com.example.demo.mianshi.thread.t12;

import lombok.SneakyThrows;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

//创建任务类，类似Runable
public class CallerTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "Hello";
    }

    @SneakyThrows
    public static void main(String[] args) {
        FutureTask<String> task = new FutureTask<>(new CallerTask());
        task.run();
        System.out.println(task.get());
    }
}
