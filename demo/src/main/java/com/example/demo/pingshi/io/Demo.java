package com.example.demo.pingshi.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author zhangyu
 * @date 2019/12/11 13:15
 */
public class Demo {

    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入一个字符");
            Object ddd = bufferedReader.read();
            System.out.println("你输入的字符为" + ddd);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
