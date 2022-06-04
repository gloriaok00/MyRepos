package com.example.demo.mianshi.list.l1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description 初始化list最佳方式
 * @date 2022/6/4 22:42
 */

public class ListOne {

    public static void main(String[] args) {
        String[] arrays={"xxx","vvv"};
        //这种初始化list的方法感觉是最好的
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(arrays));
        arrayList.add("csdsad");
        System.out.println(arrayList.size());
    }
}
