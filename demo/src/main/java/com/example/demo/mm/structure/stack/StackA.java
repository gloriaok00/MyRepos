package com.example.demo.mm.structure.stack;

/**
 * @description
 * @date 2023/2/25 21:53
 */

public class StackA {

    private final int[] array = new int[10];
    private int size = 0;
    private int top;

    //入栈
    public void push(int a) {
        if (size == 10) {
            System.out.println("入栈失败，已经达到最大值");
            return;
        }
        array[top++] = a;
        size++;
        System.out.println("成功入栈:" + a);
    }

    //出栈
    public void pop() {
        if (size == 0) {
            System.out.println("出栈失败，栈中无元素");
            return;
        }
        size--;
        System.out.println("成功出栈:" + array[--top]);
    }

    //展示
    public void display() {
        if (size == 0) {
            System.out.println("无元素");
            return;
        }
        System.out.print("展示元素: ");
        for (int i = 0; i < top; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("展示结束");
        System.out.println();
    }

    public static void main(String[] args) {

        StackA c = new StackA();
        c.push(11);
        c.push(45);
        c.push(145);
        c.display();
        c.pop();
        c.pop();
        c.pop();
        c.push(22);
        c.push(33);
        c.display();

    }

}
