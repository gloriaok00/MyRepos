package com.example.demo.pingshi.mythread.t1;

public class AsyncThread extends Thread{
    @Override
    public void run() {
        boolean b=true;
        while(b){
            try {
                System.out.println("三秒开始");
                Thread.sleep(3000);
                b=false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("三秒结束");
        System.out.println("当前线程名称:" + this.getName() + ", 执行线程名称:" + Thread.currentThread().getName() + "-hello");
    }
}
