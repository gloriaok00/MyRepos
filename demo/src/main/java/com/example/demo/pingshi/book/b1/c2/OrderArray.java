package com.example.demo.pingshi.book.b1.c2;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @description 二分法练习
 * @date 2022/12/17 12:06
 */

public class OrderArray {

    public static void main(String[] args) {

        EEArray demo = new EEArray();
        demo.init(1000);
        //search elem
        System.out.println("查找结果位置:" + demo.find(demo.a[678]));
        System.out.println("查找结果位置:" + demo.find(111));

    }
}

class EEArray {

    public long[] a;

    public void init(int size) {
        a = new long[size];
        Random r = new Random();
        //bound给的范围比较大 主要是避免重复
        a = IntStream.range(0, size).mapToLong(i -> r.nextInt(1000000)).sorted().toArray();
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
                //没找到
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

}
