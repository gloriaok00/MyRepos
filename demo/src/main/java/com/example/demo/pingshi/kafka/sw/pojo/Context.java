package com.example.demo.pingshi.kafka.sw.pojo;

import lombok.Data;

import java.util.HashMap;

@Data
public class Context {

    private String assignmentStatus;
    private Guuid deviceTypeId;
    private HashMap<String, String> assignmentMetadata;
    private HashMap<String, String> deviceMetadata;
    private Guuid deviceId;
    private DeviceStatus deviceStatus;

}
