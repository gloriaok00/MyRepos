package com.example.demo.pingshi.book.b1.c2;

/**
 * @description
 * @date 2022/12/17 12:06
 */

public class OrderArray {

    public static void main(String[] args) {

        EEArray demo = new EEArray(10);

        demo.insert(1);
        demo.insert(5);
        demo.insert(10);
        demo.insert(89);
        demo.insert(123);
        demo.insert(190);
        demo.insert(234);
        demo.insert(278);
        demo.insert(478);
        demo.insert(540);

        //display elem
        demo.display();
        System.out.println();

        //search elem
        System.out.println("查找结果位置:" + demo.find(123));
        System.out.println("查找结果位置:" + demo.find(111));

        //delete elem
        demo.delete(190);
        demo.delete(98);

        //display elem
        demo.display();

    }
}

class EEArray {

    private long[] a;
    private int eElem;

    public EEArray(int size) {
        a = new long[size];
        eElem = 0;
    }

    public void insert(long value) {
        a[eElem] = value;
        eElem++;
    }

    public int find(long searchKey) {
        int lower = 0;
        int upper = a.length - 1;
        int curIn = 0;
        while (true) {
            curIn = (lower + upper) / 2;
            if (a[curIn] == searchKey) {
                return curIn;
            } else if (lower > upper) {
                return -1;
            } else {
                if (a[curIn] < searchKey) {
                    lower = curIn + 1;
                } else {
                    upper = curIn - 1;
                }
            }
        }
    }

    public void delete(long deleteKey) {
        int index = find(deleteKey);
        if (index == -1) {
            System.out.println("删除失败,不存在key:" + deleteKey);
        } else {
            //移动数组填洞
            for (; index < eElem - 1; index++) {
                a[index] = a[index + 1];
            }
            eElem--;
            System.out.println("成功删除:" + deleteKey);
        }
    }

    public void display() {
        for (int i = 0; i < eElem; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
