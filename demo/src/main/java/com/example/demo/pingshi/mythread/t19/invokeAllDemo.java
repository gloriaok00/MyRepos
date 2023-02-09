package com.example.demo.pingshi.mythread.t19;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *  @description invokeAll学习
 *  @date  2023/2/9 14:37
 */
public class  invokeAllDemo{

	public static void main(String[] args) throws Exception {
		ExecutorService service=Executors.newFixedThreadPool(100);
		ArrayList<Callable<Integer>> list=new ArrayList<>();
		for (int i = 1; i < 1000; i++) {
			final int index=i;
			list.add(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					System.out.println(Thread.currentThread().getName()+",当前的数字为"+index);
					return index;
				}
			});
		}
		List<Future<Integer>> result= service.invokeAll(list);
		System.out.println("可以汇总计算了！");
		int sum=0;
		for (Future<Integer> future : result) {
			sum=sum+future.get();
		}
		System.out.println("结果:"+sum);
		service.shutdown();
	}

}
