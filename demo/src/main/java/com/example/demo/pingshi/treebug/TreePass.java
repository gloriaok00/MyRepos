package com.example.demo.pingshi.treebug;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @date 2021-11-11 09:58
 */

public class TreePass {
    public static void main(String[] args) {
        //当前层级当前点下的所有子节点（实战中不要慢慢去查,一次加载到集合然后慢慢处理）
        List<TreeNode> childList = new ArrayList<>();
        TreeNode t1 = new TreeNode("1", "站点1");
        TreeNode t2 = new TreeNode("2", "站点2");
        TreeNode t3 = new TreeNode("3", "站点3");
        childList.add(t1);
        childList.add(t2);
        childList.add(t3);
        List<TreeNode> childTree = new ArrayList<>();
        TreeNode o = new TreeNode();
        for (TreeNode node : childList) {
            o.setId(node.getId());
            o.setName(node.getName());
            childTree.add(o);
        }
        System.out.println(childTree.size());
    }
}
