package com.example.demo.pingshi.myinit.c4;

public class Window {

    static {
        System.out.println("Window static");
    }

    Window(int marker) {
        System.out.println("Window(" + marker + ")");
    }
}
