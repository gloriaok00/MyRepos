package com.example.demo.pingshi.book.b1.c2;

/**
 * @description
 * @date 2022/12/17 12:06
 */

public class OrderArray {

    public static void main(String[] args) {

        EArray demo = new EArray(10);

        demo.insert(112);
        demo.insert(45);
        demo.insert(1);
        demo.insert(89);
        demo.insert(23);
        demo.insert(90);
        demo.insert(34);
        demo.insert(2);
        demo.insert(4);
        demo.insert(40);

        //display elem
        demo.display();
        System.out.println();

        //search elem
        System.out.println("查找结果位置:" + demo.find(23));
        System.out.println("查找结果位置:" + demo.find(111));

        //delete elem
        demo.delete(1);
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
        int i = 0;
        for (; i < eElem; i++) {
            if (a[i] == searchKey) {
                break;
            }
        }
        //隐喻i==eElem说明没有找到
        return i;
    }

    public void delete(long deleteKey) {
        int index = find(deleteKey);
        if (index == eElem) {
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
