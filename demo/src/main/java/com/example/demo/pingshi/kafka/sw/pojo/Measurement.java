package com.example.demo.pingshi.kafka.sw.pojo;

import lombok.Data;

@Data
public class Measurement {

    private String name;
    private SubEvent event;
    private double value;

}