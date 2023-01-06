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
        demo.deleteFirst();
        demo.displayForward();
        System.out.println("========");

        demo.insertLast(6);
        demo.insertLast(7);
        demo.insertLast(8);
        demo.deleteLast();
        demo.displayBackward();
        System.out.println("========");
        demo.deleteKey(3);
        demo.displayBackward();
        System.out.println("========");
        demo.deleteKey(7);
        demo.displayBackward();
        System.out.println("========");
        demo.deleteKey(1);
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
            last = newLink;
        } else {
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(int data) {
        XLink newLink = new XLink(data);
        if (last == null) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    public void deleteFirst() {
        XLink current = first;
        if (first == null) {
            return;
        } else {
            current = current.next;
            current.previous = null;
            first = current;
        }
    }

    public void deleteLast() {
        XLink current = last;
        if (last == null) {
            return;
        } else {
            current = current.previous;
            current.next = null;
            last = current;
        }
    }

    public void deleteKey(int data) {
        XLink current = first;
        while (current.data != data) {
            current = current.next;
        }
        if (current == first) {
            first = first.next;
        } else {
            current.previous.next = current.next;
        }
        if (current == last) {
            last = last.previous;
        } else {
            current.next.previous = current.previous;
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
