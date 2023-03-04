package com.example.demo.mm.designpattern;

/**
 * @description
 * @date 2023/3/4 10:43
 */

public class InsDemo {

    private InsDemo() {
    }

    ;
    private static volatile InsDemo instance;

    public static InsDemo getInstance() {

        if (instance == null) {
            synchronized (InsDemo.class) {
                if (instance == null) {
                    instance = new InsDemo();
                }
            }
        }
        return instance;
    }
}
