package com.example.demo.pingshi.serializable.s2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @date 2022-02-28 19:44
 */

@Data
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 12121L;

    private int id;
    private String name;

}
