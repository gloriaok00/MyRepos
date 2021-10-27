package com.example.demo.pingshi.myserializable;

import com.sitewhere.grpc.model.CommonModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Car {

    private String name;

    private int model;

    private double price;

    private Date promoDate;

    private CommonModel.GUUID deviceId;
    private CommonModel.GUUID areaId;
    private CommonModel.GUUID customerId;

    private List<String> colors = new ArrayList<String>();

}
