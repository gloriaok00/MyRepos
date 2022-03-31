package com.example.demo.pingshi.datatype.fanxing;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @date 2022-03-31 10:28
 */

@Slf4j
public class AAA {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList();
        arrayList.add("aaaa");


        for(int i = 0; i< arrayList.size();i++){
            String item = (String)arrayList.get(i);
            log.info("泛型测试","item = " + item);
        }
    }
}
