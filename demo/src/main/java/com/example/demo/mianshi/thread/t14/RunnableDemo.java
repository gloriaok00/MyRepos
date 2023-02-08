package com.example.demo.mianshi.thread.t14;

/**
 *  @description 终于整明白了 其实这就是正常的按顺序执行方法 不是啥同步都
 *  @date  2023/2/8 09:52
 */

public class RunnableDemo {

    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Runnable r=new Runnable() {
            public void run() {
                try {
                    System.out.println("---begin---");
                    Thread.sleep(2000);
                    System.out.println("---end---");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        r.run();
        System.out.println("---begin interrupt threadA---");
        System.out.println("---end interrupt threadA---");
    }
}
