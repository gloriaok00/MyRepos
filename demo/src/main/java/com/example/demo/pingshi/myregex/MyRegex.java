package com.example.demo.pingshi.myregex;

/**
 * @description
 * @date 2021-11-11 15:27
 */

public class MyRegex {
    public static void main(String[] args) {
        String regex = ".+\\d+.+";
        String str = "sdasd12dsf";
        System.out.println(str.matches(regex));
        //Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    }
}
