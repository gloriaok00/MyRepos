package com.example.demo.pingshi.垃圾回收;

/**
 * @author zhangyu
 * @description 当对象大于3M时，直接放入老年代
 * @date 2020-04-19 09:52
 * -Xms20M -Xmx20M -Xmn10M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:PretenureSizeThreshold=3M -XX:SurvivorRatio=8
 */

public class BigObjGC {
    private final int mbsize=1024*1024;

    public static void main(String[] args) {
          BigObjGC minorGc =new BigObjGC();
          minorGc.gcSimulation();
    }

    public void gcSimulation(){
        byte[] allocation4;
        allocation4=new byte[4*mbsize];
    }
}
