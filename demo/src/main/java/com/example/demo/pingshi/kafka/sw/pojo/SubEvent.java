package com.example.demo.pingshi.kafka.sw.pojo;

import lombok.Data;

import java.util.HashMap;

@Data
public class SubEvent {

    private HashMap<String,Double> metadata;
    private Guuid areaId;
    private Guuid assetId;
    private Guuid customerId;
    private Guuid id;
    private Guuid deviceAssignmentId;
    private Guuid deviceId;
    private Long receivedDate;
    private Long eventDate;

}