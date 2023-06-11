package com.example.demo.mm.designpattern;

/**
 * @description 单例就用这个，来自《深入虚拟机》
 * @date 2023/6/11 13:42
 */
public class FinalSingleton {
    private volatile static FinalSingleton instance;

    public static FinalSingleton getInstance() {
        if (instance == null) {
            synchronized (FinalSingleton.class) {
                if (instance == null) {
                    instance = new FinalSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {

        FinalSingleton.getInstance();
    }
}
