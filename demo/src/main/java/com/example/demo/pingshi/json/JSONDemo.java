package com.example.demo.pingshi.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @date 2019-10-05 14:40
 */
public class JSONDemo {

    public static void main(String[] args) {
        String s = "{\n" +
                "    \"name\": \"王小二\",\n" +
                "    \"age\": 15,\n" +
                "    \"address\": {\n" +
                "        \"province\": \"浙江\",\n" +
                "        \"city\": \"杭州\",\n" +
                "        \"district\": \"西湖区\"\n" +
                "    },\n" +
                "    \"hobby\": [\n" +
                "        \"足球\",\n" +
                "        \"棒球\",\n" +
                "        \"乒乓球\"\n" +
                "    ]\n" +
                "}";
        JSONObject obj = JSONObject.parseObject(s);
        String name = obj.getString("name");
        System.out.println(name);
        JSONArray array = obj.getJSONArray("hobby");
        for (int i = 0; i < array.size(); i++) {
            String temp = array.getString(i);
            System.out.println(temp);
        }
        JSONObject address = obj.getJSONObject("address");
        String province = address.getString("province");
        System.out.println(province);

        List<String> mylist = new ArrayList<>();
        mylist.add("1");
        mylist.add("2");
        mylist.add("3");
        String result = JSONArray.toJSONString(mylist);
        System.out.println(result);

    }
}
