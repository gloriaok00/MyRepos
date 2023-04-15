package com.example.demo.mianshi.juc.threadpoolexecutor;

/**
 * @author zhangyu
 * @date 2019-09-16 22:08
 */
public class Test {

    public static void main(String[] args) {
        Singlon DDD = Singlon.getSinglon();
        Singlon2 kk= Singlon2.getInstance();
        Singlon2 kk1= Singlon2.getInstance();
        System.out.println(kk.equals(kk1));
    }
}
