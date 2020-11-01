package com.example.demo.pingshi.java8stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyu
 * @date 2019/12/9 15:11
 */
public class LianXi {
    public static void main(String[] args) {
        List<String> myStringList = Arrays.asList("1@33", "2@77", "2@66", "2@88", "6@99", "3@22");
      /*  myStringList.stream().map(e->{return e.split("@");})
                .collect(toMap(e->e[0],e->e[1],(v1,v2)->v1))
                .entrySet().forEach(s-> System.out.println(s.getKey()+"-"+s.getValue()));*/
/*        myStringList.stream().map(e -> e.split("@"))
                .collect(toMap(e -> e[0], e -> {
                    ArrayList<String> saveList = new ArrayList();
                    saveList.add(e[1]);
                    return saveList;
                }, (List<String> oldList, List<String> newList) -> {
                    oldList.addAll(newList);
                    return oldList;
                })).entrySet().forEach(e-> { System.out.println(e.getKey()+"-"+e.getValue());});*/

    }
}
