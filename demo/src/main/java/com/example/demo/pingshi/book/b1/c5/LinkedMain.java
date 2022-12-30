package com.example.demo.pingshi.book.b1.c5;

/**
 * @description 链表练习
 * @date 2022/12/26 23:44
 * @date 2022/12/29 20:37
 */

public class LinkedMain {

    public static void main(String[] args) {

        LinkX xx = new LinkX();
        xx.insert(1, 1.12);
        xx.insert(2, 2.2);
        xx.insert(3, 33.3);
        xx.insert(4, 44.09);
        xx.insert(5, 555);
        xx.find(2);
        xx.delete(3);
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

    public void delete(int id) {
        Node current = first;              // search for link
        Node previous = first;
        while (current.id != id) {
            if (current.next == null)
                return;                 // didn't find it
            else {
                previous = current;          // go to next link
                current = current.next;
            }
        }                               // found it
        if (current == first)               // if first link,
            first = first.next;             //    change first
        else                               // otherwise,
            previous.next = current.next;   //    bypass it
        System.out.println("成功删除1个元素");
    }

    public void display() {
        Node current = first;
        while (current != null) {
            System.out.print(current.value + ", ");
            current = current.next;
        }
    }

    public Node find(int id) {
        Node current = first;
        while (current != null) {
            if (current.id == id) {
                System.out.println("成功找到元素:" + current.value);
                break;
            }
            current = current.next;
        }
        return current;
    }

}
