package com.example.demo.mianshi.list;

import java.util.*;

/**
 * @author zhangyu
 * @date 2019-09-07 14:58
 */
public class MyList {

    public static void main(String[] args) {
        HashMap test=new HashMap();
        HashMap<String,Integer> test11=new HashMap<String,Integer>();
        test.put(null,"1");
        test.put(null,"2");
        String s=(String)test.get(null);
        //System.out.println(s);
        Set ss=new HashSet<String>();
        ss.add("1");
        ss.add("34");
        ss.add("34");
        ss.add("341");
        ss.add("1");
        for (Object object : ss) {
            System.out.println("set:"+object);
        }

        TreeMap treeMap=new TreeMap();
        treeMap.put("431","1");
        treeMap.put("122","122");
        treeMap.put("781","123");
        treeMap.put("101","12");

        Iterator titer=treeMap.entrySet().iterator();
        while(titer.hasNext()){
            Map.Entry ent=(Map.Entry )titer.next();
            String keyt=ent.getKey().toString();
            String valuet=ent.getValue().toString();
            System.out.println(keyt+"-"+valuet);
        }
    }
}
