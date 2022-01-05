package com.example.demo.pingshi.spring.myvalid.qiantao;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @description
 * @date 2022-01-05 16:25
 */

@Data
public class MyParamItem {

    @Min(value = 1, message = "别小于1啊")
    @Max(value = 10, message = "别大于10啊")
    public int id;

    @NotBlank(message = "不能为空")
    public String itemName;
}
