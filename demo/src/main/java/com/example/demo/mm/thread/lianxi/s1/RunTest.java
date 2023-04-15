package com.example.demo.mm.thread.lianxi.s1;

public class RunTest {

    public static void main(String[] args) {
        Service service = new Service();
        for (int i = 1; i <= 10; i++) {
            new ThreadAA(service).start();
        }
    }
}
