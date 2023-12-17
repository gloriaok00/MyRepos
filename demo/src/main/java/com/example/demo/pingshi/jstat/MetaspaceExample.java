package com.example.demo.pingshi.jstat;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.List;

public class MetaspaceExample {
    public static int count=0;
    public static void main(String[] args) throws Exception {
        while (true) {
            // 创建新类和方法，占用 Metaspace
            createClassAndMethod();
            Thread.sleep(1);
            System.out.println("第"+count+++"次");
            List<MemoryPoolMXBean> memoryPools = ManagementFactory.getMemoryPoolMXBeans();
            for (MemoryPoolMXBean pool : memoryPools) {
                if (pool.getName().contains("Metaspace")) {
                    System.out.println("Max Metaspace Size: " + pool.getUsage().getMax() / (1024 * 1024) + " MB");
                }
            }
        }
    }

    private static void createClassAndMethod() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("GeneratedClass" + System.nanoTime());
        CtMethod method = CtNewMethod.make("public void generate() {}", cc);
        cc.addMethod(method);
        cc.toClass();
    }
}
