package com.example.demo.pingshi.java8stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhangyu
 * @description java8 stream练习
 * @date 2020-04-22 13:59
 */

public class StreamDemo {

    public static void main(String[] args) {
        //list转map 复杂类型
        List<Fruit> fruitsList = new ArrayList<>();

        Fruit apple1 = new Fruit(1, "苹果1", new BigDecimal("3.25"), 10);
        Fruit apple2 = new Fruit(1, "苹果2", new BigDecimal("4.59"), 10);
        Fruit banana = new Fruit(2, "香蕉", new BigDecimal("2.89"), 30);
        Fruit lizhi = new Fruit(3, "荔枝", new BigDecimal("9.99"), 40);

        fruitsList.add(apple1);
        fruitsList.add(apple2);
        fruitsList.add(banana);
        fruitsList.add(lizhi);

        Map<Integer, Fruit> fruitHashMap = fruitsList.stream().collect(Collectors.toMap(Fruit::getId, a -> a, (k1, k2) -> k1));
     /*   fruitHashMap.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
        });*/

        //list转map 正常类型
        List<String> fruitsList1 = new ArrayList<>();

        fruitsList1.add("apple1");
        fruitsList1.add("apple2");
        fruitsList1.add("banana");
        fruitsList1.add("lizhi");

        Map<String, String> fruitHashMap1 = fruitsList1.stream().collect(Collectors.toMap(a -> a, a -> a));
       /* fruitHashMap1.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
        });*/

        //map转list 复杂类型
        HashMap<Integer, Fruit> fruitMap2 = new HashMap();
        fruitMap2.put(apple1.getId(), apple1);
        fruitMap2.put(apple2.getId(), apple2);
        fruitMap2.put(banana.getId(), banana);
        fruitMap2.put(lizhi.getId(), lizhi);

        List<String> fruitList2 = fruitMap2.entrySet().stream().map(x -> x.getValue().getName()).collect(Collectors.toList());
      /*  fruitList2.forEach(e->{
            System.out.println(e);
        });*/

        //map转list 正常类型
        HashMap<Integer, String> fruitMap3 = new HashMap();
        fruitMap3.put(apple1.getId(), apple1.getName());
        fruitMap3.put(apple2.getId(), apple2.getName());
        fruitMap3.put(banana.getId(), banana.getName());
        fruitMap3.put(lizhi.getId(), lizhi.getName());

        List<String> fruitList3 = fruitMap3.entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());
        fruitList3.forEach(e -> {
            System.out.println(e);
        });
    }
}
