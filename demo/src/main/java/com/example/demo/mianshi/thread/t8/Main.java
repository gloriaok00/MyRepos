package com.example.demo.mianshi.thread.t8;

import lombok.SneakyThrows;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @description callable练习
 * @date 2022/9/27 16:47
 */

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        FutureTask<String> task=new FutureTask<>(new cc());
        Thread t1=new Thread(task);
        t1.start();
        System.out.println(task.get());
    }

}

class cc implements Callable<String>{
    @Override
    public String call() throws Exception {
        return "返回值value";
    }
}
