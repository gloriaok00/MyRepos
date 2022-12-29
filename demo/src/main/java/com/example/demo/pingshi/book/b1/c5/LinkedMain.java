package com.example.demo.pingshi.book.b1.c5;

/**
 * @description
 * @date 2022/12/26 23:44
 */

public class LinkedMain {

    public static void main(String[] args) {
        LinkX xx = new LinkX();
        xx.insert(1, 1);
        xx.insert(2, 2);
        xx.insert(3, 3);
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

    public Node() {

    }
}

class LinkX {

    private Node first = new Node();

    public void insert(int id, double value) {
        Node x = new Node(id, value);
        x.next = first;
        first = x;
    }

    public void display() {
        while (first != null) {
            System.out.print(first.value + ", ");
            first = first.next;
        }
    }
}
