package com.example.demo.pingshi.book.b1.c3;

/**
 * @description
 * @date 2022/12/25 12:42
 */

public class BubbleSort {

    public static void main(String[] args) {
        BubbleX xx = new BubbleX(5);
        xx.insert(1);
        xx.insert(3);
        xx.insert(4);
        xx.insert(2);
        xx.insert(5);
        xx.sort();
        xx.display();
    }
}


class BubbleX {

    private int[] array;
    private int size;
    private int nElem;

    public BubbleX(int size) {
        this.size = size;
        array = new int[size];
    }

    public void sort() {
        for (int out = size - 1; out > 1; out--) {
            for (int i = 0; i < out; i++) {
                if (array[i] > array[i + 1]) {
                    swap(i, i + 1);
                }
            }
        }
    }

    public void swap(int k, int j) {
        int temp;
        temp = array[k];
        array[k] = array[j];
        array[j] = temp;
    }

    public void insert(int value) {
        if (nElem == size) {
            System.out.println("数组已经满了,无法再添加了");
            return;
        }
        array[nElem++] = value;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + ",");
        }
    }

}
