package com.example.demo.pingshi.myinit.c4;

public class House {

    static {
        System.out.println("House static");
    }

    Window w1 = new Window(1);// Before constructor

    House() {
        System.out.println("House()");
        w3 = new Window(33);
    }

    Window w2 = new Window(2);

    void f() {
        System.out.println("f()");
    }

    Window w3 = new Window(3);

}
