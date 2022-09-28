package com.example.demo.mianshi.thread.t9;

public class YieldRunnable implements Runnable{
	public volatile boolean isRunning = true;

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + "开始执行！");

		while(isRunning) {
			for(int i = 1; i < 6; i++) {
				System.out.println(name + "执行了[" + i + "]次");
				//注意，yield是静态方法
				Thread.yield();
			}
		}

		System.out.println(name + "执行结束！");
	}

	public static void main(String[] args) {
		YieldRunnable runnable1 = new YieldRunnable();
		YieldRunnable runnable2 = new YieldRunnable();
		Thread thread1 = new Thread(runnable1, "线程1");
		Thread thread2 = new Thread(runnable2, "线程2");

		System.out.println("两个线程准备开始执行");
		thread1.start();
		thread2.start();

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		runnable1.isRunning = false;
		runnable2.isRunning = false;
	}
}
