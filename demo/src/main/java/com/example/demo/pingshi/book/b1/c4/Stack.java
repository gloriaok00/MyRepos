package com.example.demo.pingshi.book.b1.c4;

/**
 * @description
 * @date 2022/12/22 23:22
 */

public class Stack {

    public static void main(String[] args) {
        //先放入三个
        StackX x = new StackX(10);
        x.push(10);
        x.push(20);
        x.push(30);

        x.display();
        //都pop出来直到空
        while (!x.isEmpty()) {
            System.out.println("pop出的元素:" + x.pop());
        }
        System.out.println("全部pop成功");

    }
}

class StackX {

    public long[] array;
    public int top;
    public int size;

    public StackX(int s) {
        this.size = s;
        array = new long[size];
        this.top = -1;
    }

    public long pop() {
        return array[top--];
    }

    public void push(long e) {
        if (top == size - 1) {
            //栈满，再放入之前请先pop
            System.out.println("当前栈已满，再放入之前请先pop");
            return;
        }
        array[++top] = e;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void display() {
        for (int i = 0; i <= top; i++) {
            System.out.println(array[i]);
        }
    }
}
