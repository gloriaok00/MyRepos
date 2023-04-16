package com.example.demo.mm.suanfa;

/**
 * @description
 * @date 2023/4/16 10:00
 */

public class Xuanze {

    public static void main(String[] args) {
        int[] a = {13, 22, 130, 4, 51, 69};
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
