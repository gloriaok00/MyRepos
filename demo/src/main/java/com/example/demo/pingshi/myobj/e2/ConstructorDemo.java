package com.example.demo.pingshi.myobj.e2;

public class ConstructorDemo {
    public ConstructorDemo() {
    }

    public ConstructorDemo(int num) {

    }

    {
        System.out.println("construct code  block!");
    }

    public static void main(String[] args) {
        ConstructorDemo c1 = new ConstructorDemo();
        ConstructorDemo c2 = new ConstructorDemo(2);
    }
}
