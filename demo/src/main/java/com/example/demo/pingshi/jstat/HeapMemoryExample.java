package com.example.demo.pingshi.jstat;

import java.util.ArrayList;
import java.util.List;

public class HeapMemoryExample {
    private static int count=1;
    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();

        try {
            while (true) {
                objects.add(new Object());
                Thread.sleep(10);
                System.out.println("创建了第"+count+++"个对象");
            }
        } catch (OutOfMemoryError | InterruptedException e) {
            System.out.println("OutOfMemoryError: " + e.getMessage());
        }
    }
}
