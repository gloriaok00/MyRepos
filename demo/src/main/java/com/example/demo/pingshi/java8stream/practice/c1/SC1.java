package com.example.demo.pingshi.java8stream.practice.c1;

import java.util.Arrays;

/**
 * @description 随机练习
 * @date 2022-04-20 10:22
 */

public class SC1 {
    public static void main(String[] args) {
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};

        Arrays.sort(players, String::compareTo);
        new Thread(()-> System.out.println("我是runnable")).start();
    }
}
