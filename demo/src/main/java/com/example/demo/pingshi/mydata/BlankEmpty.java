package com.example.demo.pingshi.mydata;

import cn.hutool.core.util.StrUtil;

/**
 * @description 随机练习
 * @date 2022/8/14 13:38
 */

public class BlankEmpty {

    public static void main(String[] args) {
        System.out.println(StrUtil.isBlank("  "));//true
        System.out.println(StrUtil.isEmpty("  "));//false
    }
}
