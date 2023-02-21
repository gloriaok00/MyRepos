package com.example.demo.mm.thread.comser;

import java.util.concurrent.*;
/**
 *  @description 完成的就返回
 *  @date  2023/2/21 17:41
 */
public class CompletionServiceDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//1、创建一个线程池
		ExecutorService executorService = Executors.newCachedThreadPool();

		CompletionService<String> completionService = new ExecutorCompletionService<String>(executorService);

		completionService.submit(new WorkThread("线程1"));
		completionService.submit(new WorkThread1("线程2"));

		executorService.shutdown();

		System.out.println(completionService.take().get());
		System.out.println(completionService.take().get());
	}
}
