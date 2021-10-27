package com.example.demo.pingshi.复杂对象.list;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;

/**
 * @author zhangyu
 * @description 判断集合的空
 * @date 2021-10-27 11:08
 */

public class ListNullDemo {

    public static void main(String[] args) {
        //ArrayList<String> dd=new ArrayList();
        ArrayList<String> dd=null;
        System.out.println(CollUtil.isEmpty(dd));
        System.out.println(dd.size()==0);
    }
}
