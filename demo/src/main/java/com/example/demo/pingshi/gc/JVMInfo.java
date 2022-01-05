package com.example.demo.pingshi.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * @author zhangyu
 * @description JVM用的虚拟机
 * @date 2020-04-18 09:27
 */

public class JVMInfo {

    public static void main(String[] args) {
        List<GarbageCollectorMXBean> l = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean b : l) {
            System.out.println(b.getName());
        }

    }
}
