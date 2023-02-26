package com.example.demo.mm.structure.queue;

/**
 * @description
 * @date 2023/2/26 00:36
 */

public class Queue {

    private int front;
    private int rear;
    private int size;
    private final int length = 10;
    private int[] array = new int[length];

    //入队
    public void offer(int a) {
        if (rear == length) {
            System.out.println("无法入队，已满");
        }
        array[rear++] = a;
    }

    //出队
    public void poll() {
        if (array[0] == 0) {
            System.out.println("无法出队，已满");
        }
        int a = array[front];
        array[front] = 0;
        front++;
        System.out.println("出队元素:" + a);
    }

    //展示
    public void display() {
        System.out.print("展示元素:");
        for (int i = 0; i < length; i++) {
            if (array[i] != 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.print("展示结束");
        System.out.println();
    }

    public static void main(String[] args) {

        Queue queue = new Queue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.display();
        queue.poll();
        queue.display();

    }

}
