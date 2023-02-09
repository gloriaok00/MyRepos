package com.example.demo.pingshi.mythread.t19;

import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @description invokeAll练习
 * @date 2023/2/9 15:55
 */
public class InvokeAllThread {

    static ExecutorService mExecutor = Executors.newFixedThreadPool(5);

    private class QuoteTask implements Callable<BigDecimal> {
        public final double price;
        public final int num;

        public QuoteTask(double price, int num) {
            this.price = price;
            this.num = num;
        }

        @Override
        public BigDecimal call() throws Exception {
            Random r = new Random();
            long time = (r.nextInt(10) + 1) * 1000;
            Thread.sleep(time);

            BigDecimal d = BigDecimal.valueOf(price * num).setScale(2);
            System.out.println("耗时：" + time / 1000 + "s,单价是：" + price + ",人数是："
                    + num + "，总额是：" + d);
            return d;
        }
    }


    public void getRankedTravelQuotes() throws InterruptedException {
        List<QuoteTask> tasks = new ArrayList<>();
        // 模拟10个计算旅游报价的任务
        for (int i = 1; i <= 10; i++) {
            tasks.add(new QuoteTask(200, i));
        }

        //这里当加上5s的时间限制后 当随机产生的时间大于5时就直接抛弃了
        mExecutor.invokeAll(tasks, 5L, TimeUnit.SECONDS);

        System.out.println("全完事了");

        mExecutor.shutdown();
    }


    @SneakyThrows
    public static void main(String[] args) {
        InvokeAllThread it = new InvokeAllThread();
        it.getRankedTravelQuotes();
    }

}

