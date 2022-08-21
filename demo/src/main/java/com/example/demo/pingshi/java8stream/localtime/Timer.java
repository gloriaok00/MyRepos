package com.example.demo.pingshi.java8stream.localtime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @description java8 time新写法 git revert--从staged变回modified
 * @date 2022/8/21 01:55
 */

public class Timer {

    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(time.format(formatter));
    }

}
