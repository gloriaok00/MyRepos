package com.example.demo.pingshi.gc;

/**
 * @author zhangyu
 * @description 放入allocation4时，发现新生代内存不够，引发MinorGC，放入到另一个Survivor里不够，于是把之前的6M都放入到了老年代，然后allocation4放入到了新生代
 * @date 2020-04-18 17:32
 * -Xms30M -Xmx30M -Xmn15M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 */

public class MinorGC {
    private final int mbsize = 1024 * 1024;

    public static void main(String[] args) {
        MinorGC minorGc = new MinorGC();
        minorGc.gcSimulation();
    }

    public void gcSimulation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * mbsize];
        allocation2 = new byte[2 * mbsize];
        allocation3 = new byte[2 * mbsize];
        allocation4 = new byte[4 * mbsize];
    }
}
