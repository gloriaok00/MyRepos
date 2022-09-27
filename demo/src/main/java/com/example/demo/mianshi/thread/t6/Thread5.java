package com.example.demo.mianshi.thread.t6;

/**
 * @description 主线程执行完了 与子线程没关系 子线程该执行还是执行自己的
 * @date 2022/9/27 11:53
 */

public class Thread5 {

    public static void main(String[] args) {
        Runnable r = () -> {
            while (true) {
                System.out.println("我就是不想结束怎么的吧");
            }
        };
        r.run();
        System.out.println("main end");
    }
}
