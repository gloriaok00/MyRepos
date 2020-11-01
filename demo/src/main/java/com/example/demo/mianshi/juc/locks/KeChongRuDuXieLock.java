package com.example.demo.mianshi.juc.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhangyu
 * @date 2019-09-14 13:05
 * 读写锁
 */
class MyCache {

    private volatile Map map = new HashMap<Integer, Object>();
    private ReentrantReadWriteLock mylock=new ReentrantReadWriteLock();

    public void put(int key,Object value){
        Thread currentThread=Thread.currentThread();
        mylock.writeLock().lock();
        try{
            System.out.println(currentThread.getName()+"正在写入");
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key,value);
            System.out.println(currentThread.getName()+"写完");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mylock.writeLock().unlock();
        }
    }

    public void get(int key){
        Thread currentThread=Thread.currentThread();
        mylock.readLock().lock();
        try{
            System.out.println(currentThread.getName()+"正在读");
            TimeUnit.MILLISECONDS.sleep(100);
            map.get(key);
            System.out.println(currentThread.getName()+"读完");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mylock.readLock().unlock();
        }
    }
}
public class KeChongRuDuXieLock{

    public static void main(String[] args) {
        MyCache cache=new MyCache();
        for (int i = 0; i < 5; i++) {
            final int temp=i;
            new Thread(()->{
                cache.put(temp,temp);
            },"t"+temp).start();
        }

        for (int i = 0; i < 5; i++) {
            final int temp=i;
            new Thread(()->{
                cache.get(temp);
            },"t"+temp).start();
        }
    }
}
