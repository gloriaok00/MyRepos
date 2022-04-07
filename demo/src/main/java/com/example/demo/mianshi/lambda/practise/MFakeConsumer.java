package com.example.demo.mianshi.lambda.practise;

import java.util.HashSet;

/**
 * @description 综合练习 模仿consumer功能
 * @date 2022-04-07 09:27
 */

public class MFakeConsumer {
    
    public static void main(String[] args) {
        HashSet<String> datas = new HashSet<>();
        datas.add("a");
        datas.add("b");
        datas.add("c");

        for (String data : datas) {
            doingAny(data,e->{
                System.out.println(e + "test");
            });
        }

    }

    public static void doingAny(String param,FakeConsumer<String> fc){
        fc.fakeConsume(param);
    }
}
