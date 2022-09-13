package com.example.demo.mianshi.rest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description 手机号校验
 * @date 2022/9/13 11:17
 */

public class PhonePattern {

    public static boolean isMobile(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(14[0|5|6|7|9])|(15[0-3])|(15[5-9])|(16[5|6|7])|(17[1-8])|(18[0-9])|(19[1|8|9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    public static void main(String[] args) {
        boolean b = isMobile("18128417513");
        if (b) {
            System.out.println("手机号符合规则。");
        } else {
            System.out.println("这个号码不符合规则");
        }
    }

}
