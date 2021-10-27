package com.example.demo.pingshi.listener;


import javax.swing.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author zhangyu
 * @description
 * @date 2020-05-01 19:31
 */

public class ListernerTime {

    public static void main(String[] args) {
        TimePrinter tp = new TimePrinter();
        Timer t = new Timer(1000, tp);
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plus(10, ChronoUnit.SECONDS);
        t.start();
        while (true) {
            LocalDateTime now = LocalDateTime.now();
            if (now.compareTo(end) == 1) {
                System.out.println("距离启动已经10秒了,该停止了");
                t.stop();
                break;
            }
        }
    }
}
