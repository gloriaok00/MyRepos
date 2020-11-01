package com.example.demo.mianshi.juc.blockqueue;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyu
 * @date 2019-09-15 15:34
 */

class MyThread implements Callable{
    @Override
    public Object call() throws Exception {
        System.out.println(" 计算中 from callable");
        TimeUnit.SECONDS.sleep(2);
        return 101;
    }
}

public class MyCallable {
    public static void main(String[] args) throws Exception {
        FutureTask futureTask=new FutureTask(new MyThread());
        new Thread(futureTask,"AA").start();
        System.out.println(Thread.currentThread().getName()+"继续...");
        int result2=100;
        int result1=(int)futureTask.get();
        System.out.println(result1+result2);
    }
}
