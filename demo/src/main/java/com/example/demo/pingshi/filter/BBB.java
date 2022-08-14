package com.example.demo.pingshi.filter;

/**
 * @description
 * @date 2022/8/10 21:03
 */

public class BBB {

    public static void main(String[] args) {
        long start = 0L;
        long end = 0L;


        System.out.println("字符串拼接执行效率比较：");

        String s1 = "";
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {//十万次
            s1 = s1 + "a";
        }
        end = System.currentTimeMillis();
        System.out.println("1、+ 方式拼接10万次耗时：" + (end - start) + "毫秒!");

        String s2 = "";
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {//十万次
            s2 += "b";
        }
        end = System.currentTimeMillis();
        System.out.println("2、+= 方式拼接10万次耗时：" + (end - start) + "毫秒!");

        StringBuffer bf = new StringBuffer();
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {//千万次
            bf.append("c");
        }
        end = System.currentTimeMillis();
        System.out.println("3、StringBuffer.append 方式拼接1000万次耗时：" + (end - start) + "毫秒!");

        StringBuilder bl=new StringBuilder();
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {//千万次
            bl.append("d");
        }
        end = System.currentTimeMillis();
        System.out.println("4、StringBuilder.append 方式拼接1000万次耗时：" + (end - start) + "毫秒!");
    }
}
