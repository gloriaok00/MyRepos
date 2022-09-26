package com.example.demo.mianshi.thread.t2;

public class Join02 {

    public static void main(String[] args) {

        Runnable girl = () -> {
            int time = 1000;

            System.out.println("女孩开始化妆,男孩在等待。。。");

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("女孩化妆完成！，耗时" + time);
        };


        Runnable boy = () -> {
            System.out.println("男孩和女孩准备出去逛街");

            Thread girl1 = new Thread(girl);
            girl1.start();

            try {
                girl1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("男孩和女孩开始去逛街了");
        };
        boy.run();

    }

}
