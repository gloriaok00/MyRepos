package com.example.demo.mianshi.thread.t11;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *  @description future get
 *  @date  2022/9/29 10:31
 */
public class Main {

    public static void main(String[] args) throws Exception {

        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future<Integer> f1 = pool.submit(new MyCallable(100, "1号"));
        Future<Integer> f2 = pool.submit(new MyCallable(200, "2号"));

        //f1.get()会阻塞当前主线程的运行，但不影响已经执行的其他线程
        Integer i2 = f2.get();
        System.out.println(i2);

        Integer i1 = f1.get();
        System.out.println(i1);

        // 结束
        //如果不调用线程池对象的shutdown方法，当线程池里面的任务执行完毕后主线程这个JVM不会退出。
        pool.shutdown();

    }

    static class MyCallable implements Callable<Integer> {

        private int number;
        private String name;

        public MyCallable(int number, String name) {
            this.number = number;
            this.name = name;
        }

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int x = 1; x <= number; x++) {
                sum += x;
            }

            if (number == 100) {
                Thread.sleep(2000);
            } else {
                Thread.sleep(4000);
            }
            System.out.println(name + "执行完了");
            return sum;
        }

    }
}
