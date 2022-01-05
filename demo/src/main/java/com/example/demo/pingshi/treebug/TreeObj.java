package com.example.demo.pingshi.treebug;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @date 2021-11-11 09:48
 */

public class TreeObj {

    public static void main(String[] args) {
        List<TreeNode> treeList = new ArrayList<>();
        TreeNode t1 = new TreeNode("1", "站点1");
        TreeNode t2 = new TreeNode("2", "站点2");
        TreeNode t3 = new TreeNode("3", "站点3");
        treeList.add(t1);
        treeList.add(t2);
        treeList.add(t3);
        List<TreeNode> ll = new ArrayList<>();
        TreeNode o = new TreeNode("", "");
        for (TreeNode t : treeList) {
            t.setId(t.getId());
            t.setName(t.getName());
            ll.add(t);
        }
        System.out.println(ll.size());
    }
}
