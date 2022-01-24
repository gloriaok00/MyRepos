package com.example.demo.pingshi.rest;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>
 * 资源表
 * </p>
 *
 * @author ${author}
 * @since 2022-01-21
 */
@Data
@AllArgsConstructor
public class UPermission {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String url;


}
