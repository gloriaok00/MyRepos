package com.example.demo.pingshi.oom;

import java.util.HashSet;

/**
 * @author zhangyu
 * @description 运行常量池内存溢出
 * @date 2020-04-16 15:47
 */

public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        int i = 0;
        HashSet set = new HashSet();
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
