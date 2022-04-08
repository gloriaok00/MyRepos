package com.example.demo.mianshi.lambda.p2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @date 2022-04-07 10:23
 */

public class PP22 {

    public static List<String> datas = new ArrayList<>();

    @Before
    public void initData(){
        datas.add("a");
        datas.add("b");
        datas.add("c");
    }

    @Test
    public void access() {
        // 遍历集合，如果发现集合中存在就删除
        String str = "a";
        datas.removeIf(d->d.equals(str));

        // 打印
        datas.forEach(System.out::println);
    }

}
