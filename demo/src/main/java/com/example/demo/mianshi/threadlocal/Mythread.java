package com.example.demo.mianshi.threadlocal;

/**
 * @author zhangyu
 * @date 2019-09-07 12:20
 */
public class Mythread implements Runnable{
    ThreadLocal threadLocals = new ThreadLocal();

    @Override
    public void run() {

        System.out.println(3);
    }
}
