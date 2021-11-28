package com.example.demo.pingshi.innerclass.interfacenew;

/**
 * @description
 * @date 2021-11-28 22:18
 */

public class Bird{

    public static void main(String[] args) {
        IFly iFly=new IFly() {
            @Override
            public void fly() {
                System.out.println("匿名内部类，把接口实例化了");
            }
        };
        iFly.fly();
    }
}
