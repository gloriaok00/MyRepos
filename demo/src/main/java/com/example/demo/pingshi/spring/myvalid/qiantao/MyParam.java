package com.example.demo.pingshi.spring.myvalid.qiantao;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @description
 * @date 2021-12-16 04:35
 */

@Data
public class MyParam {

    @NotBlank
    public String paramId;

    @Valid//当需要嵌套校验MyParamItem里的字段时，这里一定要加@Valid
    @NotNull
    public MyParamItem paramItem;

}
