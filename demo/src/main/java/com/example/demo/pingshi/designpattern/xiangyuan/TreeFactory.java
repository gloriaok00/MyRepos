package com.example.demo.pingshi.designpattern.xiangyuan;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeFactory {

    static List<TreeType> treeTypes=new ArrayList<>();

    static TreeType getTreeType(String name, String color, String texture) {
        TreeType type = null;
        Iterator<TreeType> xx = treeTypes.iterator();
        while (xx.hasNext()) {
            TreeType mm=xx.next();
            if (mm.getColor().equals(color)) {
                if (mm.getName().equals(name)) {
                    if (mm.getTexture().equals(texture)) {
                        type = xx.next();
                        System.out.println("老对象");
                        break;
                    }
                }
            }
        }
        if (type == null) {
            type = new TreeType(name, color, texture);
            System.out.println("新对象");
            treeTypes.add(type);
        }

        return type;
    }

    public static void main(String[] args) {
        TreeType tt = new TreeType("T1", "Green", "绿树");
        TreeType tt1 = new TreeType("T2", "Red", "枫叶树");
        TreeType tt2 = new TreeType("T3", "Yellow", "黄树");
        treeTypes.add(tt);
        treeTypes.add(tt1);
        treeTypes.add(tt2);
        TreeType xx=getTreeType("T1","Green","绿树");
        //TODO toString
        System.out.println(xx.toString());
    }
}
