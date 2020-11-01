package com.example.demo.pingshi.树形聚合;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangyu
 * @create 2020-10-25 13:54
 */
public class TreeRecursion {

    public static void main(String[] args) {

        Map<String,Node> nodes = new HashMap();
        //模拟数据库存储树结构
        nodes.put("1",new Node("1","root","0"));
        nodes.put("a1",new Node("a1","1号厂","1"));
        nodes.put("a2",new Node("a2","2号厂","1"));
        nodes.put("a3",new Node("a3","3号厂","1"));
        nodes.put("dt1",new Node("dt1","热压罐","a1"));
        nodes.put("dt2",new Node("dt2","门禁","a1"));
        nodes.put("dt3",new Node("dt3","刀具","a2"));
        nodes.put("d5",new Node("d5","压力枪","dt3"));
        nodes.put("d1",new Node("d1","五米热压罐","dt1"));
        nodes.put("d2",new Node("d2","十米热压罐","dt1"));
        nodes.put("d3",new Node("d3","前门门禁","dt2"));
        nodes.put("d4",new Node("d4","后门门禁","dt2"));

        System.out.println("result:" + JSON.toJSONString(getNodeJson("0",nodes)));
    }

    /**
     * 递归处理   数据库树结构数据->树形json
     * @param nodeId
     * @param nodes
     * @return
     */
    public static JSONArray getNodeJson(String nodeId, Map<String,Node> nodes){

        //当前层级当前点下的所有子节点（实战中不要慢慢去查,一次加载到集合然后慢慢处理）
        List<Node> childList = getChildNodes(nodeId,nodes);

        JSONArray childTree = new JSONArray();
        for (Node node : childList) {
            JSONObject o = new JSONObject();
            o.put("name", node.getName());
            o.put("id",node.getId());
            JSONArray childs = getNodeJson(node.getId(),nodes);  //递归调用该方法
            if(!childs.isEmpty()) {
                o.put("children",childs);
            }
            childTree.fluentAdd(o);
        }
        return childTree;
    }

    /**
     * 获取当前节点的所有子节点
     * @param nodeId
     * @param nodes
     * @return
     */
    public static List<Node> getChildNodes(String nodeId, Map<String,Node> nodes){
        List<Node> list = new ArrayList<>();
        for (String key : nodes.keySet() ) {
            if(nodes.get(key).getParentId().equals(nodeId)){
                list.add(nodes.get(key));
            }
        }
        return list;
    }

}