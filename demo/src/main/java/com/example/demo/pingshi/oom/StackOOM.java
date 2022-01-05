package com.example.demo.pingshi.oom;

/**
 * @author zhangyu
 * @description 栈内存溢出(局部变量过大)
 * @date 2020-04-15 23:24
 */

public class StackOOM {

    private int i = 1;

    private void addNum() {
        i++;
        addNum();
    }

    public static void main(String[] args) {
        StackOOM stackOOM = new StackOOM();
        stackOOM.addNum();
    }
}
