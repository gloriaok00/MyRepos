package com.example.demo.mm.structure.stack;

/**
 * @description 链表实现栈
 * @date 2023/2/25 21:53
 */

public class Node {

    private int value;
    private Node next;
    private Node top;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node() {

    }

    //入栈
    public void push(int a) {
        if (top == null) {
            top = new Node(a, null);
            return;
        }
        Node newTop = new Node(a, top);
        top = newTop;
    }

    //出栈
    public void pop() {
        if (top == null) {
            System.out.println("出栈失败，栈中无元素");
            return;
        }
        int result = top.value;
        top = top.next;
        System.out.println("成功出栈:" + result);
    }

    //展示
    public void display() {
        //需要临时变量 要么在display后top的位置会变化 导致其它的方法再次用top就不对了
        Node tempTop = top;
        if (tempTop == null) {
            System.out.println("无元素");
            return;
        }
        System.out.print("展示元素(栈顶自上而下顺序): ");
        while (tempTop != null) {
            System.out.print(tempTop.value + " ");
            tempTop = tempTop.next;
        }
        System.out.print("展示结束");
        System.out.println();
    }

    public static void main(String[] args) {

        Node c = new Node();
        c.push(11);
        c.push(45);
        c.push(145);
        c.push(78);
        c.push(23);
        c.display();
        c.pop();
        c.pop();
        c.display();

    }

}
