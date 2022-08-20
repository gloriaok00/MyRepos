package com.example.demo.pingshi.java8stream.localtime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @description java8 time新写法
 * @date 2022/8/21 01:55
 */

public class Timer {

    public static void main(String[] args) {
        LocalDateTime now1 = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(now1.format(formatter));
    }

}
