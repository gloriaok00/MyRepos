package com.example.demo.pingshi.siddhi.http;

import lombok.Data;

/**
 * @author zhangyu
 * @description
 * @date 2021-04-08 04:53
 */

@Data
public class ValidateLoan {


    private long clientId;
    private String name;
    private double amount;

}
