package com.example.demo.pingshi.myabstract;

public abstract class B {
	private String str;

	public B(String a){
		System.out.println("父类已经实例化");
		this.str = a;
		System.out.println(str);
	}

	public abstract void play();
}
