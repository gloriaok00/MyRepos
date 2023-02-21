package com.example.demo.mm.thread.manyget;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

/**
 * @description 模拟返回结果封装类
 * @date 2023/2/21 13:56
 */

@Data
@AllArgsConstructor
public class RestResult<T> {

    private T data;
    private int code;
    private String msg;

}
