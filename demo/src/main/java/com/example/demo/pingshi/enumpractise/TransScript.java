package com.example.demo.pingshi.enumpractise;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;

/**
 * @author zhangyu
 * @description 翻译优化
 * @date 2022-03-01 22:22
 */

public class TransScript {

    public static void main(String[] args) {
        //这里用hutool的httpUtil，这样url里面的空格什么的都会直接帮着转译处理好
        String gt = HttpUtil.get("http://fanyi.youdao.com/translate?&doctype=json&type=AUTO&i=" + "啊啊啊 我中间有空格啊", null, 1000);
        JSONObject obj = JSONObject.parseObject(gt);
        JSONObject sss = obj.getJSONArray("translateResult").getJSONArray(0).getObject(0, JSONObject.class);
        System.out.println(sss.getString("tgt"));
        String tgt = sss.getString("tgt");
    }

}
