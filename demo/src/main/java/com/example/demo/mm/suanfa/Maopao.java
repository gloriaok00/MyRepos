package com.example.demo.mm.suanfa;

/**
 * @description  冒泡的思想是每次把最大的往后放
 * @date 2023/4/16 10:00
 */

public class Maopao {

    public static void main(String[] args) {
        int[] a = {13, 22, 130, 4, 51, 69};
        int temp;
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-i-1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
