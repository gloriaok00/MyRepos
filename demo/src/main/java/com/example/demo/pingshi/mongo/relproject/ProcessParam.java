package com.example.demo.pingshi.mongo.relproject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessParam {

    //名称
    private String name;
    //设定值
    private double staValue;
    //平均值
    private double avgValue;
    //最大值
    private double maxValue;
    //最小值
    private double minValue;
    //标准差
    private double staDeviation;

    public ProcessParam(String name) {
        this.name = name;
    }

}
