package com.example.demo.pingshi.book.b1.c8;

/**
 * @description
 * @date 2023/1/8 14:07
 */

public class BinaryTreeDemo {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        //tree.inOrder(tree.root);
        //System.out.println();
        //tree.find(2);
        tree.delete(3);
        tree.inOrder(tree.root);
    }
}

class Node {

    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
    }

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
        while (current.data != data) {
            if (data < current.data) {
                current = current.left;
            } else if (data > current.data) {
                current = current.right;
            }
            if (current == null) {
                System.out.println("没找到" + data);
                return;
            }
        }
        System.out.println("已找到" + current.data);
    }

    public void insert(int data) {
        Node current = root;
        Node parent;
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            while (true) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrder(Node current) {
        if (current != null) {
            inOrder(current.left);
            System.out.print(current.data + ",");
            inOrder(current.right);
        }
    }

    public void delete(int data) {
        Node current = root;
        Node parent = root;
        boolean isLeft = true;
        while (current.data != data) {
            parent = current;
            if (data < current.data) {
                isLeft = true;
                current = current.left;
            } else if (data > current.data) {
                isLeft = false;
                current = current.right;
            }
            if (current == null) {
                System.out.println("没有找到");
                break;
            }
        }

        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
                System.out.println("树为空");
            } else if (isLeft) {
                parent.left = null;
                System.out.println("删除左节点成功");
            } else {
                parent.right = null;
                System.out.println("删除右节点成功");
            }
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeft) {
                parent.left=current.left;
            } else {
                parent.right=current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeft) {
                parent.left=current.right;
            } else {
                parent.right=current.right;
            }
        }

    }

}
