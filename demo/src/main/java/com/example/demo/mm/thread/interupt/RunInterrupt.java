package com.example.demo.mm.thread.interupt;

/**
 * @description 运行状态下 调interrupt是没用的
 * @date 2023/2/22 09:48
 */

public class RunInterrupt {

    public static void main(String[] args) {

        Thread xx= new ThreadDemo();
        xx.start();
        xx.interrupt();
        while (true){
            System.out.println(2);
        }

    }
}

