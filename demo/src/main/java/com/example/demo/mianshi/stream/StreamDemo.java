package com.example.demo.mianshi.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author zhangyu
 * @date 2019-08-22 12:56
 */
public class StreamDemo {
    public static void main(String[] args) {
        Stream s1= Stream.of("herew","jui","laopao");
        String[] myArr=new String[]{"a","hbb","sdad"};
        List<String> myList= Arrays.asList(myArr);
        Stream s2=myList.stream();
        //IntStream.of(new int[]{2,3,4}).forEach(System.out::println);
        //IntStream.range(3,8).forEach(System.out::println);
        int[] intArr=new int[]{1,2,3,4,5};
        System.out.println(IntStream.of(intArr).map(i->i*2).reduce(0,Integer::sum));
    }
}
