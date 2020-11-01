package com.example.demo.pingshi.数据类型;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author zhangyu
 * @description HashMap类型相关操作
 * @date 2020-10-25 11:21
 */

public class HashMapDemo {

    public static void main(String[] args) {

    }

    @Test
    public void container(){
        HashMap<String,String> map=new HashMap<>();
        map.put("1adf","ddf");
        map.put("qaz","wsx");
        map.put("edc","asd");
        System.out.println("在hashmap里的字符串，contains方法不能部分匹配:"+map.containsKey("1a"));

        boolean result="1adf".contains("1a");
        System.out.println("单纯的字符串里的是可以的:"+result);
    }
}
