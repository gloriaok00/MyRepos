package com.example.demo.mianshi.cas;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author zhangyu
 * @date 2019-09-09 15:14
 */
public class MyAtomicStampedReference {

    static AtomicReference<Integer> atomicReference=new AtomicReference<Integer>(100);
    public static void main(String[] args) {
        /*
        new Thread(()->{
            System.out.println(atomicReference.compareAndSet(100,101)+"\t"+atomicReference.get());
            System.out.println(atomicReference.compareAndSet(101,100)+"\t"+atomicReference.get());
        },"t1").start();

        new Thread(()->{
            try{
                TimeUnit.SECONDS.sleep(1);
                System.out.println(atomicReference.compareAndSet(100,105)+"\t"+atomicReference.get());
            }catch (Exception e){
                e.printStackTrace();
            }
        },"t2").start();
 */


        AtomicStampedReference<Integer> atomicStampedReference=new AtomicStampedReference<Integer>(100,1);
        new Thread(()->{
            System.out.println(atomicStampedReference.compareAndSet(100,101,1,2)+"\t"+atomicReference.get()+"-"+atomicStampedReference.getStamp());
            System.out.println(atomicStampedReference.compareAndSet(101,100,2,3)+"\t"+atomicReference.get()+"-"+atomicStampedReference.getStamp());
        },"t3").start();

        new Thread(()->{
            System.out.println(atomicStampedReference.compareAndSet(100,101,3,4)+"\t"+atomicReference.get()+"-"+atomicStampedReference.getStamp());
        },"t4").start();
    }
}
