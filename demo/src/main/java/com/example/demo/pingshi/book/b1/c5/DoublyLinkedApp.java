package com.example.demo.pingshi.book.b1.c5;

/**
 * @description 双向链表
 * @date 2023/1/6 14:15
 */

public class DoublyLinkedApp {

    public static void main(String[] args) {

        DoublyLink demo = new DoublyLink();
        demo.insertFirst(1);
        demo.insertFirst(2);
        demo.insertFirst(3);
        demo.insertFirst(4);
        demo.insertLast(6);
        demo.insertLast(7);
        demo.insertLast(8);

        demo.displayForward();
        System.out.println("========");
        demo.displayBackward();

    }
}

class XLink {

    public int data;
    public XLink next;
    public XLink previous;

    public XLink(int data) {
        this.data = data;
    }
}

class DoublyLink {

    public XLink first;
    public XLink last;

    public void insertFirst(int data) {
        XLink newLink = new XLink(data);
        if (first == null) {
            first = newLink;
        } else {
            first.previous = newLink;
            newLink.next = first;
            first = newLink;
        }
    }

    public void insertLast(int data) {
        XLink newLink = new XLink(data);
        if (last == null) {
            last = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
            last = newLink;
        }
    }

    //从前往后遍历
    public void displayForward() {
        XLink current = first;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    //从后往前遍历
    public void displayBackward() {
        XLink current = last;
        while (current != null) {
            System.out.println(current.data);
            current = current.previous;
        }
    }

}
