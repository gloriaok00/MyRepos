package com.example.demo.mianshi.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author zhangyu
 * @date 2019-09-11 11:23
 */
public class SafeList {

    public static void main(String[] args) {

        //List list= Collections.synchronizedList(new ArrayList<>());
        List list= new CopyOnWriteArrayList(new ArrayList<>());
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
              list.add(UUID.randomUUID().toString().substring(0,8));
              System.out.println(list);
            },String.valueOf(i)).start();
        }
        HashSet set=new HashSet();
    }
}
