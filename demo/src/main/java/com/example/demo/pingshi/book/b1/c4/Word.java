package com.example.demo.pingshi.book.b1.c4;

/**
 * @description
 * @date 2022/12/22 23:22
 */

public class Word {

    public static void main(String[] args) {
        String xxx = "hello";
        char[] mm = xxx.toCharArray();

        WordX x = new WordX(mm.length);
        for (int i = 0; i < mm.length; i++) {
            x.push(mm[i]);
        }

        x.display();
        //都pop出来直到空
        while (!x.isEmpty()) {
            System.out.println("pop出的元素:" + x.pop());
        }
        System.out.println("全部pop成功");

    }
}

class WordX {

    public char[] array;
    public int top;
    public int size;

    public WordX(int s) {
        this.size = s;
        array = new char[size];
        this.top = -1;
    }

    public char pop() {
        return array[top--];
    }

    public void push(char e) {
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
