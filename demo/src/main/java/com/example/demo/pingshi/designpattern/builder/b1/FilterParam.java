package com.example.demo.pingshi.designpattern.builder.b1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 日期筛选参数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilterParam {

    //型壳开始时间
    private String s1;
    //型壳结束时间
    private String s2;
    //浇注开始时间
    private String s3;
    //浇注结束时间
    private String s4;
    //铸件交付开始时间
    private String s5;
    //铸件交付结束时间
    private String s6;

}
