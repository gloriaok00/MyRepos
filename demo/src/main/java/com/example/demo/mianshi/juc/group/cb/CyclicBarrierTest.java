package com.example.demo.mianshi.juc.group.cb;

import java.util.Map;
import java.util.concurrent.*;

public class CyclicBarrierTest implements Runnable{

    /*创建一个CyclicBarrier实例,屏障数据设为3,处理完之后执行当前类的run方法*/
    private CyclicBarrier cb = new CyclicBarrier(3,this);

    /*创建线程池,只有三个月的数据,所以只需三个线程*/
    private Executor executor = Executors.newFixedThreadPool(3);

    /*创建一个ConcurrentHashMap,用来保存每个sheet计算出的结果*/
    private ConcurrentHashMap<String,Integer> sheetBankWaterCount = new ConcurrentHashMap<String, Integer>();

    public void count() {
        for(int i = 0;i<3;i++){

            /*每个线程用来处理单个sheet中的任务*/
            executor.execute(new Runnable() {

                public void run() {

                    /*此处加入复杂的逻辑处理代码*/
                    sheetBankWaterCount.put(Thread.currentThread().getName(),1);

                    try {

                        /*线程完成工作后调用await 设置屏障*/
                        cb.await();
                    }catch (BrokenBarrierException e){
                        e.printStackTrace();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
            });
        }
    }


    /*等到所有的线程到达屏障*/

    public void run() {
        int res = 0;
        /*根据之前多线程的结果计算出整个季度的银行流水*/
        for (Map.Entry<String,Integer> sheet: sheetBankWaterCount.entrySet()) {
            res += sheet.getValue();
        }

        sheetBankWaterCount.put("result",res);
        /*将结果输出*/
        System.out.println(res);
    }

    public static void main(String[] args){

        CyclicBarrierTest test = new CyclicBarrierTest();

        /*注意,此时不需要调用test.run(),最后一个await方法会调用run方法*/
        test.count();
    }
}
