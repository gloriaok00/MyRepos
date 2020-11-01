/*
 * Copyright (C) 2019 com.lf.ibms, Inc. All Rights Reserved.
 */

package com.example.demo.pingshi.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Person {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private String age;

}
