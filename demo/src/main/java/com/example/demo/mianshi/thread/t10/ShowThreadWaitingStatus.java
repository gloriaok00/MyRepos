package com.example.demo.mianshi.thread.t10;


/**
 *  @description 线程状态学习
 *  @date  2022/9/28 15:27
 */

public class ShowThreadWaitingStatus implements Runnable {

	public static void main(String[] args) {
		ShowThreadWaitingStatus runnable = new ShowThreadWaitingStatus();
		Thread thread1 = new Thread(runnable);
		thread1.start();
		Thread thread2 = new Thread(runnable);
		thread2.start();
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 打印出TIME_WAITING,原因是:Thread.sleep(1000);
		System.out.println("线程1的状态:" + thread1.getState());
		// 打印出BLOCKED，因为线程2拿不到method的方法锁
		System.out.println("线程2的状态:" + thread2.getState());
		try {
			Thread.sleep(1400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 打印出WAITING，因为wait()方法，使线程进入到WAITING状态
		System.out.println("线程1的状态:" + thread1.getState());
		// 打印出TIME_WAITING，因为Thread.sleep(1000)方法，使线程进入到TIME_WAITING状态
		System.out.println("线程2的状态:" + thread2.getState());
	}

	@Override
	public void run() {
		method();
	}

	/**
	 *
	 */
	private synchronized void method() {
		try {
			System.out.println("当前线程:"+Thread.currentThread().getName());
			Thread.sleep(1000);
			wait();
			//System.out.println(Thread.currentThread().getName() + ",状态是：" + Thread.currentThread().getState());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
