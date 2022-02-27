package com.example.demo.pingshi.enumpractise;

/**
 * @author zhangyu
 * @description 翻译优化
 * @date 2022-02-25 11:02
 */

public class EnumDemo {
    public static void main(String[] args) {
        for (EnumWeek value : EnumWeek.values()) {
            System.out.println(value.getName());
          /*  String gt = HttpUtil.get("http://fanyi.youdao.com/translate?&doctype=json&type=AUTO&i="+ value.getName(),null,1000);
            JSONObject obj = JSONObject.parseObject(gt);
            JSONObject sss = obj.getJSONArray("translateResult").getJSONArray(0).getObject(0, JSONObject.class);
            System.out.println(sss.getString("tgt"));
            String tgt = sss.getString("tgt");*/
        }
        System.out.println(EnumWeek.valueOf("Monday"));
    }
}
