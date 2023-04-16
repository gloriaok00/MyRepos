package com.example.demo.mm.suanfa;

/**
 * @description
 * @date 2023/4/16 13:26
 */
public class Kuaipai {

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int c = partition(arr, left, right);
            sort(arr, left, c - 1);
            sort(arr, c + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int c = left;
        int cv = arr[left];
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < cv) {
                c++;
                swap(arr, i, c);
            }
        }
        swap(arr, left, c);
        return c;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {13, 22, 130, 4, 51, 69, 101, 2, 90};
        sort(a, 0, 8);
        for (int i = 0; i < a.length - 1; i++) {
            System.out.println(a[i]);
        }
    }

}
