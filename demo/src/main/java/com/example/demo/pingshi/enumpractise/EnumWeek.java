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
    Tuesday(2,"星期二"),
    Wednesday(3,"星期三"),
    Thursday(4,"星期四"),
    Friday(5,"星期五"),
    Saturday(6,"星期六"),
    Sunday(7,"星期日");

    private Integer code;
    private String name;

}
