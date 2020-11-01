package com.example.demo.pingshi.常量池;

/**
 * @author zhangyu
 * @description 字符串的两种常量池
 * @date 2020-04-16 17:24
 */

public class StringConstantPool {

    public static final String a="123";
    public static final String b="456";

/*    static {
        a = "123";
        b = "456";
    }*/

    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "Hel" + "lo";
        String s4 = "Hel" + new String("lo");
        String s5 = new String("Hello");
        String s6 = s5.intern();
        String s7 = "H";
        String s8 = "ello";
        String s9 = s7 + s8;
        String s10=new String("Hello");

        //true
        System.out.println(s1 == s2);
        //true
        System.out.println(s1 == s3);
        //false
        System.out.println(s1 == s4);
        //false
        System.out.println("s1 == s9:"+(s1 == s9));
        //false
        System.out.println(s4 == s5);
        //true
        System.out.println(s1 == s6);
        //false
        System.out.println(s5 == s10);

        //true
        String c = "123456";
        String d = a + b;
        System.out.println(c == d);
    }
}
