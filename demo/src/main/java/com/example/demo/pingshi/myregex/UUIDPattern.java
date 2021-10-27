package com.example.demo.pingshi.myregex;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangyu
 * @description 正则表达式练习
 * @date 2020-09-03 13:31
 */

public class UUIDPattern {

    /**
     * 标准的UUID
     * 32位16进制的数字，用分隔符分成8-4-4-4-12的格式
     */
    private static final Pattern UUID_PATTERN = Pattern.compile("[0-9a-f]{8}(-[0-9a-f]{4}){3}-[0-9a-f]{12}");
    //private static final Pattern numberPattern = Pattern.compile("([a-z]+)(\d+)");
    private static Pattern p = Pattern.compile("\\d+");

    /**
     * 判断一个字符串是否是有效的UUID
     *
     * @param uuid
     * @return
     */
    public static boolean isValidUUID(String uuid) {
        Matcher matcher = UUID_PATTERN.matcher(uuid);
        return matcher.matches();
    }

    /**
     * 随机生成UUID
     *
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {

       /* Matcher m=numberPattern.matcher("aaa2223bb");
        System.out.println(m.matches());*/
      /* String s="sitewhere.sitewhere.tenant.bc741b11-b55e-48d3-ad92-8f1355e50147.outbound-events";
       String s1="sitewhere.sitewhere.tenant.7.outbound-events";
       String s2="sitewhere.sitewhere.tenant.bc741b11-b55e-48d3-ad92-8f1355e50147.event-source-failed-decode-events";

       if(s2.contains(".outbound-events")){
           System.out.println(true);
       }else{
           System.out.println(false);
       }*/
        UUIDPattern demo = new UUIDPattern();
        demo.getSubUtilSimple("sitewhere.sitewhere.tenant.0dbe5580-4c37-4f6e-9bc6-cd489d33ec6b.outbound-events", "sitewhere.sitewhere.tenant.(.*?).outbound-events");
    }

    public void getSubUtilSimple(String soap, String rgex) {
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        System.out.println(m.find());
        System.out.println(m.group(1));
    }

}
