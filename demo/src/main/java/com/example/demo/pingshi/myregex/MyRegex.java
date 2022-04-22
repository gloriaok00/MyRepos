package com.example.demo.pingshi.myregex;

import java.util.regex.Pattern;

/**
 * @description
 * @date 2021-11-11 15:27
 */

public class MyRegex {
    public static void main(String[] args) {
        //方式1
        String regex = ".+\\d+.+";
        String str = "sdasd12dsf";
        System.out.println(str.matches(regex));
        //方式2
        //mongodb xx.put("nn", Pattern.compile("^.*" + cc +".*$",Pattern.CASE_INSENSITIVE));
        Pattern p=Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        //方式3
        System.out.println(Pattern.matches(regex,str));
    }
}
