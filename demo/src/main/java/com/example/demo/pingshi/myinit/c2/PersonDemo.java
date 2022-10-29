package com.example.demo.pingshi.myinit.c2;

//构造代码块中定义的是不同对象共性的初始化内容
class Person
{
	private String name;
	private int age;

	Person()
	{
		name = "Lisi";
		age = 20;
		System.out.println(name);
	}

	//构造代码块
	{
		speak();
	}

	Person(String namee)
	{
		name = namee;
		System.out.println(namee);
	}


	Person(String namee, int agee)
	{
		name = namee;
		age = agee;
		System.out.println(namee);
	}

	void speak()
	{
		System.out.print("talk...");
	}

}

public class PersonDemo
{
	public static void main(String[] args)
	{
		Person p1 = new Person();
		Person p2 = new Person("Zhangsan");
		Person p3 = new Person("Wangwu", 24);
	}
}
