package com.example.demo.pingshi.datatype.mymap;

import java.util.*;

/**
 * @description map类型的排序学习
 * @date 2022-04-01 09:58
 */

public class MapSort {

    public static void main(String[] args) {

        //HashMap
        System.out.println("------HashMap无序输出------");
        HashMap hsMap = new HashMap();
        hsMap.put("3", "Value3");
        hsMap.put("1", "Value1");
        hsMap.put("5", "Value5");
        hsMap.put("2", "Value2");
        hsMap.put("b", "ValueB");
        hsMap.put("a", "ValueA");
        System.out.println(hsMap.entrySet());

        //TreeMap
        System.out.println("------TreeMap按Key排序输出------");
        TreeMap teMap = new TreeMap();
        teMap.put("3", "Value3");
        teMap.put("1", "Value1");
        teMap.put("2", "Value2");
        teMap.put("b", "ValueB");
        teMap.put("a", "ValueA");
        System.out.println(teMap.entrySet());


        //LinkedHashMap
        System.out.println("--LinkedHashMap根据输入的顺序输出--");
        LinkedHashMap lhsMap = new LinkedHashMap();
        lhsMap.put("3", "Value3");
        lhsMap.put("1", "Value1");
        lhsMap.put("2", "Value2");
        lhsMap.put("b", "ValueB");
        lhsMap.put("a", "ValueA");
        System.out.println(lhsMap.entrySet());
    }

}
