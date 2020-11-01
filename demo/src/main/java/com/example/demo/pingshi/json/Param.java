package com.example.demo.pingshi.json;

import lombok.Data;

import java.util.List;

/**
 * @author zhangyu
 * @date 2019-10-28 21:14
 */
@Data
public class Param {

    private String name;
    private int num;
    private List<String> sites;
}
