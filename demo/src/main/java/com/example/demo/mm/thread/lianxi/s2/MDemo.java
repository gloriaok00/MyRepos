package com.example.demo.mm.thread.lianxi.s2;

import lombok.SneakyThrows;

/**
 * @description  他们拿到的都是同一个对象
 * @date 2023/4/15 17:01
 */

public class MDemo {

    public static void main(String[] args) {
        MDemo zz=new MDemo();
        new Thread(()->{
            zz.s1();
         }).start();
        new Thread(()->{
            zz.s2();
        }).start();
        new Thread(()->{
            zz.s3();
        }).start();
        new Thread(()->{
            zz.s4();
        }).start();
    }

    @SneakyThrows
    public synchronized void s1(){
        System.out.println("我是s1，我拿到当前对象的monitor了");
        Thread.sleep(5000);
        System.out.println("我是s1，我还当前对象的monitor了");
    }

    @SneakyThrows
    public synchronized void s2(){
        System.out.println("我是s2，我拿到当前对象的monitor了");
        Thread.sleep(7000);
        System.out.println("我是s2，我还当前对象的monitor了");
    }

    @SneakyThrows
    public synchronized void s3(){
        System.out.println("我是s3，我拿到当前对象的monitor了");
        Thread.sleep(1000);
        System.out.println("我是s3，我还当前对象的monitor了");
    }

    @SneakyThrows
    public synchronized void s4(){
        System.out.println("我是s4，我拿到当前对象的monitor了");
        Thread.sleep(100);
        System.out.println("我是s4，我还当前对象的monitor了");
    }

}
