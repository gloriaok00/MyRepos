package com.example.demo.pingshi.mythread.t5;

import com.example.demo.mianshi.cas.User;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @descriptio Myfuture异步阻塞
 * @date 2022/9/11 17:16
 */

public class MyFuture {

    public static void main(String[] args) {
        System.out.println("主线程开始");
        MyFuture aaa = new MyFuture();
        //会以异步阻塞的方式取到结果
        aaa.asyncGetUser();
        System.out.println("主线程结束");
    }

    public Future<User> asyncGetUser() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<User> future = executorService.submit(() -> {
            Thread.sleep(6000);
            return GU.getUser();
        });
        try {
            User u = future.get();
            System.out.println(u.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return future;
    }
}

class GU {
    public static User getUser() {
        return new User("异步阻塞", 23);
    }
}
