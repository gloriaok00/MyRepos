/*
 * Copyright (C) 2019 com.lf.ibms, Inc. All Rights Reserved.
 */

package com.example.demo.pingshi.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * Simple to Introduction
 * className: PersonImportDTO
 *
 * @author zhangyu
 * @version 2019/7/25 10:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonImportDTO {

    /**
     * 姓名
     */
    @NotEmpty
    private String name;

    /**
     * 年龄
     */
    @Max(150)
    @Min(0)
    private String age;

}
