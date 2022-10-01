package com.example.demo.pingshi.constantpool;

/**
 * @description 随机练习
 * @date 2022/10/1 16:57
 */

public class StrMain {

    public static void main(String[] args) {
        System.out.println("start:"+System.currentTimeMillis());
        for (int i = 0; i < 10000; i++) {
           /* String s1= UUID.randomUUID().toString();
            String s2= UUID.randomUUID().toString();
            String s3=s1+s2;
            System.out.println(s3);*/
            String s3="1af34c8b-31e7-46f6-8f79-2028c2c903383e7ccbae-ecd4-4a2b-b0b7-93ea226c91ed";
            System.out.println(s3);
        }
        System.out.println("end:"+System.currentTimeMillis());
    }
}
