package com.example.demo.pingshi.enumpractise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author zhangyu
 * @date 2019-10-26 21:47
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EnumWeek {

    Monday(1,"星期一"),
    Tuesday(2,"星期二");

    private int code;
    private String name;


}
