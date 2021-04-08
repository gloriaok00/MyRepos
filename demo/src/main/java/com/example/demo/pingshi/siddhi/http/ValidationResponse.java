package com.example.demo.pingshi.siddhi.http;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhangyu
 * @description
 * @date 2021-04-08 05:26
 */

@Data
@AllArgsConstructor
public class ValidationResponse {

    private boolean isValid;
    private double rate;
    private int years_approved;

}
