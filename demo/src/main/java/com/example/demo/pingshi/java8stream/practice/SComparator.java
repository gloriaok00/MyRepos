package com.example.demo.pingshi.java8stream.practice;

import java.util.Comparator;

/**
 * @description 外部比较器
 * @date 2022-03-31 13:03
 */

public class SComparator implements Comparator<SSS> {

    @Override
    public int compare(SSS o1, SSS o2) {
       return Integer.compare(o1.getA(),o2.getA());
    }
}
