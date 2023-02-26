package com.example.demo.mm.structure.link;

/**
 *  @description 链表 做个简单的：删除和添加都在头的位置的
 *  @date  2023/2/26 13:31
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

    //添加
    public void add(int a) {
        if (top == null) {
            top = new Node(a, null);
            return;
        }
        Node newTop = new Node(a, top);
        top = newTop;
    }

    //删除
    public void remove() {
        if (top == null) {
            System.out.println("无元素可删除");
            return;
        }
        int result = top.value;
        top = top.next;
        System.out.println("成功删除:" + result);
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
        c.add(11);
        c.add(45);
        c.add(145);
        c.add(78);
        c.add(23);
        c.display();
        c.remove();
        c.remove();
        c.display();

    }

}
