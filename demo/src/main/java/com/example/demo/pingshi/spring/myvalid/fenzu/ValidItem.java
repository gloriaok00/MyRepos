package com.example.demo.pingshi.spring.myvalid.fenzu;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @description
 * @date 2022-01-05 16:58
 */

@Data
public class ValidItem {

    @NotBlank(groups = {UpdateGroup.class})
    private String id;

    private String name;

}
