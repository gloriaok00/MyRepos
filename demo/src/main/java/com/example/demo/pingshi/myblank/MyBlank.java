package com.example.demo.pingshi.myblank;

import cn.hutool.core.util.StrUtil;

/**
 * @description blank里包含了对于空格的判断
 * @date 2021-11-08 22:56
 */

public class MyBlank {

    public static void main(String[] args) {
        System.out.println(StrUtil.isBlank(" "));
        System.out.println(StrUtil.isEmpty(" "));
    }
}
