package com.example.demo.pingshi.myobj.e1;

import javax.annotation.PostConstruct;

public class Mammal {

    public Mammal() {
        System.out.println("构造器");
    }

    {
        System.out.println("游离代码块");
    }

    @PostConstruct
    public void xx() {
        System.out.println("PostConstruct方法..本身没在servlet环境中");
        System.out.println("所以看上去像不生效了");
        System.out.println("虽然是在jdk里的注解 但是应用在servlet中的");
    }

    public static void main(String[] args) {
        Mammal mm = new Mammal();

    }
}
