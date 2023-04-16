package com.example.demo.mm.suanfa;

/**
 * @description 首先遍历整个数组，记录当前未排序部分中的最小值，
 * 然后将最小值与当前未排序部分的首位元素进行交换。
 * @date 2023/4/16 10:00
 */

public class Xuanze {

    public static void main(String[] args) {
        int[] a = {13, 22, 130, 4, 51, 69,101,2,90};
        for (int i = 0; i < a.length-1; i++) {
            int min=i;
            for (int j = i+1; j < a.length; j++) {
                if(a[j]<a[min]){
                   min=j;
                }
            }
            if (min != i) {
               int temp=a[i];
               a[i]=a[min];
               a[min]=temp;
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
