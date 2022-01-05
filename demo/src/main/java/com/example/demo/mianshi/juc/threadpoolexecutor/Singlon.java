package com.example.demo.mianshi.juc.threadpoolexecutor;

/**
 * @author zhangyu
 * @date 2019-09-16 10:47
 */
public class Singlon {
    private static Singlon singlon = null;

    private Singlon() {
    }

    ;

    public static Singlon getSinglon() {

        if (singlon == null) {
            synchronized (Singlon.class) {
                if (singlon == null) {
                    return singlon = new Singlon();
                }
                ;
            }
        }
        return singlon;
    }
}
