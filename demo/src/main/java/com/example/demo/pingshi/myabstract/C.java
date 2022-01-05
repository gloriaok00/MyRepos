package com.example.demo.pingshi.myabstract;

/**
 * @description 抽象类利用父类的引用来指向子类的实例进行实例化
 * @date 2021-11-08 15:24
 */

public class C extends B {

    public C(String c) {
        super(c);
        System.out.println("子类已经被实例化");
    }

    @Override
    public void play() {
        System.out.println("我实现了父类的方法");
    }

    public static void main(String[] args) {
        B c = new C("c");
        c.play();
    }
}
