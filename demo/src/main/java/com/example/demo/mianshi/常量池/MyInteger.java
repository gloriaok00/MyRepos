package com.example.demo.mianshi.常量池;

/**
 * @author zhangyu
 * @date 2019-09-08 10:47
 */
public class MyInteger {
    public static void main(String[] args) {
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);

        //true
        System.out.println("i1=i2   " + (i1 == i2));
        //true
        System.out.println("i1=i2+i3   " + (i1 == i2 + i3));
        //false
        System.out.println("i1=i4   " + (i1 == i4));
        //false
        System.out.println("i4=i5   " + (i4 == i5));
        //true
        System.out.println("i4=i5+i6   " + (i4 == i5 + i6));
        //不知道
        System.out.println("40=i5+i6   " + (40 == i5 + i6));


        //part2
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        //true
        System.out.println(c == d);
        //false
        System.out.println(e == f);
        //true
        System.out.println(c == (a + b));
        //true
        System.out.println(c.equals(a + b));
        //true
        System.out.println(g == (a + b));

        System.out.println(g.equals(a + b));
        System.out.println(g.equals(a + h));
    }
}
