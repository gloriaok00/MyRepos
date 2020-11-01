package com.example.demo.pingshi.java8stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Data
@Getter
@AllArgsConstructor
public class Fruit {
    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer num;
}