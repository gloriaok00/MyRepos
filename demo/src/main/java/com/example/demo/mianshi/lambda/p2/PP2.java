package com.example.demo.mianshi.lambda.p2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @description Predicate断言型接口学习与练习
 * @date 2022-04-08 13:26
 */

public class PP2 {

    public List<String> myFilter(List<String> strList, Predicate<String> predicate){
        List<String> result=new ArrayList<>();
        strList.forEach(e->{
            if (predicate.test(e)) {
                result.add(e);
            }
        });
        return result;
    }

    public static void main(String[] args) {
        List<String> fruit = Arrays.asList("香蕉", "哈密瓜", "榴莲", "火龙果", "水蜜桃");
        PP2 a=new PP2();
        List<String> ll=a.myFilter(fruit,(f)->f.length()==2);
        System.out.println("结果为:");
        ll.forEach(System.out::println);
    }
}
