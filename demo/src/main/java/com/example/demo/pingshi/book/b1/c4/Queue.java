package com.example.demo.pingshi.book.b1.c4;

/**
 * @description
 * @date 2022/12/24 13:00
 */

public class Queue {

    public static void main(String[] args) {
        QueueX qq = new QueueX(5);
        qq.insert(1L);
        qq.insert(2L);

        qq.remove();
        qq.insert(3L);
        qq.insert(4L);
        qq.insert(5L);
        qq.insert(6L);
        qq.insert(7L);

        qq.remove();
        qq.display();
    }

}

class QueueX {

    public Long[] queArray;
    public int rear;
    public int front;
    public int nElems;
    public int maxSize;

    public QueueX(int size) {
        front = 0;
        rear = -1;
        nElems = 0;
        maxSize = size;
        queArray = new Long[size];
    }

    public void insert(long e) {
        if (nElems == maxSize) {
            System.out.println("队列已满...无法再添加元素了");
            return;
        }
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = e;
        nElems++;
    }

    public long peekFront() {
        return queArray[front];
    }

    public void remove() {
        if (nElems == 0) {
            System.out.println("队列已空...无法再移除元素了");
            return;
        }
        if (front == maxSize) {
            front = 0;
        }
        queArray[front++] = null;
        nElems--;
    }

    public void display() {
        for (int i = 0; i < 5; i++) {
            System.out.print(queArray[i] + " ");
        }
    }

}
