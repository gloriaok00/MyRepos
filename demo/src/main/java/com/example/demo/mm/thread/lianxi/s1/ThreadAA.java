package com.example.demo.mm.thread.lianxi.s1;

public class ThreadAA extends Thread {

	private Service service;
	public ThreadAA(Service service){
		super();
		this.service=service;
	}
	@Override
	public void run(){
		service.setUsernamePassword();
	}
}
