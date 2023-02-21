package com.example.demo.mm.thread.manyget;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @description 异步获取不同时长的结果
 * @date 2023/2/21 10:06
 */

public class FutureDemo {

    public static void main(String[] args) {
        ExecutorService mm = Executors.newFixedThreadPool(3);
        Callable<Integer> c1 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                return 1;
            }
        };
        Future<Integer> r1 = mm.submit(c1);
        Callable<Integer> c2 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                return 2;
            }
        };
        Future<Integer> r2 = mm.submit(c2);
        Callable<Integer> c3 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(3000);
                return 3;
            }
        };
        Future<Integer> r3 = mm.submit(c3);
        List<Callable<Integer>> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
       /* try {
            System.out.println("线程1的结果" + r1.get(2000, TimeUnit.MILLISECONDS));
            System.out.println("线程2的结果" + r2.get(3, TimeUnit.SECONDS));
            System.out.println("线程3的结果" + r3.get(4, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }*/
        try {
            List<Future<Integer>> pp = mm.invokeAll(list);
            System.out.println(pp.get(0).get());
            System.out.println(pp.get(1).get());
            System.out.println(pp.get(2).get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        mm.shutdown();
    }
}
