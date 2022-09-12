package com.example.demo.pingshi.mystr;

import java.util.regex.Pattern;

/**
 * @description 去除特殊字符
 * @date 2022/9/10 01:34
 */

public class StrangeStr {

    /**
     * 去除特殊字符
     */
    public static String filtration(String str) {
        String regEx = "[`_~!@#$%^&*()+=|{}:;\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？']";
        str = Pattern.compile(regEx).matcher(str).replaceAll("").trim();
        return str;
    }
}
