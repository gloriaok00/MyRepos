package com.example.demo.pingshi.tree.sw;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pingshi.tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jack cooper
 * @create 2017-09-15 16:53
 */
public class TreeRecursionSW {

    public static void main(String[] args) {

        List<DeviceNode> devices=new ArrayList<>();
        devices.add(new DeviceNode("a1","dt1","d1"));
        devices.add(new DeviceNode("a1","dt1","d2"));
        devices.add(new DeviceNode("a1","dt2","d3"));
        devices.add(new DeviceNode("a2","dt3","d4"));
        devices.add(new DeviceNode("a3","dt4","d5"));

        Map<String, Node> nodes = new ConcurrentHashMap();
        nodes.put("1",new Node("1","root","0"));

        //模拟数据库存储树结构
        devices.forEach(e->{
            nodes.put(e.getArea(),new Node(e.getArea(),e.getArea(),"1"));
        });

        for (String key:nodes.keySet()){
            if(!key.equals("1")){
                for (DeviceNode t:devices){
                    if(t.getArea().equals(key)){
                        nodes.put(t.getDeviceType(),new Node(t.getDeviceType(),t.getDeviceType(),key));
                    }
                }
            }
        }

        for (String key:nodes.keySet()){
            if(!key.equals("1")){
                for (DeviceNode t:devices){
                    if(t.getDeviceType().equals(key)){
                        nodes.put(t.getDevice(),new Node(t.getDevice(),t.getDevice(),key));
                    }
                }
            }
        }

        System.out.println("result:" + JSON.toJSONString(getNodeJson("0",nodes)));
    }

    /**
     * 递归处理   数据库树结构数据->树形json
     * @param nodeId
     * @param nodes
     * @return
     */
    public static JSONArray getNodeJson(String nodeId, Map<String,Node> nodes){

        //当前层级当前node对象
        Node cur = nodes.get(nodeId);
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
