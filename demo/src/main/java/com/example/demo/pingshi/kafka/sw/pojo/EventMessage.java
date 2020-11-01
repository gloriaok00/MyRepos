package com.example.demo.pingshi.kafka.sw.pojo;

import lombok.Data;

@Data
public class EventMessage {

    private Context context;
    private Event event;

}