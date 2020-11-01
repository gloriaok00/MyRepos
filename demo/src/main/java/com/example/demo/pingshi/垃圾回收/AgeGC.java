package com.example.demo.pingshi.垃圾回收;

/**
 * @author zhangyu
 * @description 每熬过一次GC，年龄增加一次
 * @date 2020-04-21 16:56
 *
 * -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 */

public class AgeGC {
    private final int mbsize=1024*1024;

    public static void main(String[] args) {
          AgeGC minorGc =new AgeGC();
          minorGc.gcSimulation();
    }

    public void gcSimulation(){
        byte[] allocation1,allocation2,allocation3;
        allocation1=new byte[mbsize/4];
        allocation2=new byte[5*mbsize];
        allocation3=new byte[5*mbsize];
        allocation3=null;
        allocation3=new byte[5*mbsize];
    }
}
