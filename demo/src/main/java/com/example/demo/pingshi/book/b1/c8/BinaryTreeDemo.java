package com.example.demo.pingshi.book.b1.c8;

/**
 * @description
 * @date 2023/1/8 14:07
 */

public class BinaryTreeDemo {

    public static void main(String[] args) {
        Tree tree=new Tree();
        tree.find(23);
    }
}

class Node {

    public int data;
    public Node left;
    public Node right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

}

class Tree {
    public Node root;

    public void find(int data) {
        Node current = root;
        while (current != null) {
            if (data < current.data) {
                current = current.left;
            } else if (data > current.data) {
                current = current.right;
            } else {
                System.out.println("已找到" + current.data);
            }
        }
        System.out.println("没有找到" + data);
    }
}
