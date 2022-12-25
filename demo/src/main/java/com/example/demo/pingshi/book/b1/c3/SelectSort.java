package com.example.demo.pingshi.book.b1.c3;

/**
 * @description
 * @date 2022/12/25 12:42
 */

public class SelectSort {

    public static void main(String[] args) {
        SelectX xx = new SelectX(5);
        xx.insert(1);
        xx.insert(3);
        xx.insert(4);
        xx.insert(2);
        xx.insert(5);
        xx.sort();
        xx.display();
    }
}


class SelectX {

    private int[] array;
    private int size;
    private int nElem;

    public SelectX(int size) {
        this.size = size;
        array = new int[size];
    }

    public void sort() {
        int min;
        for (int out = 0; out < size - 1; out++) {
            min = out;
            for (int in = out + 1; in < size; in++) {
                if (array[in] < array[min]) {
                    swap(in, min);
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
