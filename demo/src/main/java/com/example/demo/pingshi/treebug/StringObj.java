package com.example.demo.pingshi.treebug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description 输出正常
 * @date 2021-11-11 09:10
 */

public class StringObj {
    public static void main(String[] args) {
        List<String> childList = Arrays.asList("站点1", "站点2", "站点3");
        List<String> childTree = new ArrayList<>();
        String o;
        for (String node : childList) {
            o = node;
            childTree.add(o);
        }
        System.out.println(childTree.size());
    }
}
