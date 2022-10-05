package com.example.demo.pingshi.constantpool.cspl;

import org.junit.Test;

/**
 * @description 随机练习
 * @date 2022/10/5 12:41
 */

public class C1 {

    @Test
    public void s1() {
        String str2 = new String("str") + new String("01");
        str2.intern();
        String str1 = "str01";
        System.out.println(str2 == str1);
    }

    @Test
    public void s2() {
        String str2 = new String("str") + new String("01");
        String str1 = "str01";
        str2.intern();
        System.out.println(str2 == str1);
    }

    @Test
    public void s3() {
        String s1 = "abc";
        String s2 = "a";
        String s3 = "bc";
        String s4 = s2 + s3;
        System.out.println(s1 == s4);
    }

    @Test
    public void s4() {
        String s1 = "abc";
        String s4 = "a" + "bc";
        System.out.println(s1 == s4);
    }

    @Test
    public void S5() {
        String s1 = "abc";
        final String s2 = "a";
        final String s3 = "bc";
        String s4 = s2 + s3;
        System.out.println(s1 == s4);
    }


    @Test
    public void S6() {
        String s = new String("abc");
        String s1 = "abc";
        String s2 = new String("abc");
        System.out.println(s == s1.intern());
        System.out.println(s == s2.intern());
        System.out.println(s1 == s2.intern());

    }
}
