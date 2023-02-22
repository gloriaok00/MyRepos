package com.example.demo.mm.thread.interupt;

/**
 * @description
 * @date 2023/2/22 10:51
 */
class ThreadDemo extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("1");
        }
    }
}
