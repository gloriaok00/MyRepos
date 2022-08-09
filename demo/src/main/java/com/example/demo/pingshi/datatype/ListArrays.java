package com.example.demo.pingshi.datatype;

import java.util.Arrays;
import java.util.List;

/**
 * @description list vs array  随机练习
 * @date 2022/8/9 15:41
 */

public class ListArrays {

    public static void main(String[] args) {
        String[] ss={"a","b","cc"};
        List<String> aa= Arrays.asList(ss);
        Object[] xx=aa.stream().toArray();
        System.out.println(xx.length);
    }
}
