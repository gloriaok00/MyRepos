package com.example.demo.pingshi.book.b1.c5;

/**
 * @description 链表练习
 * @date 2022/12/26 23:44
 * @date 2022/12/29 20:37
 */

public class LinkedMain {

    public static void main(String[] args) {

        LinkX xx = new LinkX();
        xx.insert(1, 1);
        xx.insert(2, 2);
        xx.insert(3, 3);

        xx.delete();
        xx.display();

    }

}

class Node {

    public Node next;
    public int id;
    public double value;

    public Node(int id, double value) {
        this.id = id;
        this.value = value;
    }

}

class LinkX {

    private Node first;

    public void insert(int id, double value) {
        Node x = new Node(id, value);
        x.next = first;
        first = x;
    }

    public void delete() {
        first = first.next;
        System.out.println("成功删除1个元素");
    }

    public void display() {
        while (first != null) {
            System.out.print(first.value + ", ");
            first = first.next;
        }
    }
}
