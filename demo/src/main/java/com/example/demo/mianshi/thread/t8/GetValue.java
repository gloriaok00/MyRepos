package com.example.demo.mianshi.thread.t8;

import java.util.concurrent.*;

/**
 * @description
 * @date 2022/9/27 16:56
 */

public class GetValue {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(new cc2());
        System.out.println(submit.get());
    }
}

class cc2 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "返回值value";
    }
}
