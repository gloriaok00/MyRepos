package com.example.demo.mm.thread.lianxi.s1;

//Java还支持对任意对象作为对象监视器来实现同步功能，非this对象
public class Service {

	private String xx= new String();

	public void setUsernamePassword(){
		try {
			synchronized (xx) {
				System.out.println("线程名称为： "+Thread.currentThread().getName()+"在同步代码块");
				Thread.sleep(3000);
				System.out.println("线程名称为： "+Thread.currentThread().getName()+"离开同步代码块");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


}
