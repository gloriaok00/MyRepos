package com.example.demo.mianshi.thread.t2;

public class JoinTest {

    public static void main(String[] args) {

        Runnable girl=()->{
            int time = 5000;

            System.out.println("女孩开始化妆,男孩在等待。。。");

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("女孩化妆完成！，耗时" + time);

        };

        Runnable boy=()->{

            System.out.println("男孩和女孩准备出去逛街");

            Thread girl1 = new Thread(girl);
            girl1.start();

            int time = 2000;
            try {
                girl1.join(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("男孩等了" + time + ", 不想再等了，去逛街了");
        };
        boy.run();
    }

}
