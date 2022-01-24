package com.example.demo.pingshi.datatype;

import org.springframework.util.AntPathMatcher;

/**
 * @description AntPathMatcher学习
 * @date 2022-01-24 11:11
 */

public class SDemo {

    public static void main(String[] args) {
        AntPathMatcher pm=new AntPathMatcher();
        String s="/authapi/**";
        String s1="/api/devices/v2/devices";
        if(pm.matchStart("/api/**",s1)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
