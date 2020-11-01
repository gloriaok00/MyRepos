package com.example.demo.pingshi.内存溢出;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @description 堆内存溢出
 * @date 2020-04-15 22:08
 */

public class HeapOOM {

    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<OOMObject>();
        while(true){
            list.add(new OOMObject());
        }
    }
}

class OOMObject{

}