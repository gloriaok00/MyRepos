package com.example.demo.pingshi.myserializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sitewhere.grpc.model.CommonModel;
import com.sitewhere.spi.SiteWhereException;

import java.util.Date;
import java.util.UUID;

public class GsonCustomSerializationDemo {

    public static void main(String args[]) throws Exception{

        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        gsonBuilder.registerTypeAdapter(Date.class, new CustomDateSerializer());
        //gsonBuilder.registerTypeAdapter(Date.class, new CustomDateDeserializer());
        //gsonBuilder.registerTypeAdapter(CommonModel.GUUID.class, new CustomGUUIDSerializer());
        Gson gson = gsonBuilder.create();

        Car car = new Car();
        car.setName("AUDI");
        car.setModel(2014);
        car.setPrice(30000);
        car.setPromoDate( new Date());
        UUID deviceId= UUID.randomUUID();
        car.setDeviceId(asGrpcUuid(deviceId));
        UUID areaId= UUID.randomUUID();
        car.setAreaId(asGrpcUuid(areaId));
        UUID customerId= UUID.randomUUID();
        car.setCustomerId(asGrpcUuid(customerId));

        car.getColors().add("GRAY");
        car.getColors().add("BLACK");
        car.getColors().add("WHITE");

        String jsonString = gson.toJson(car);
        System.out.println("对象转成的string是:");
        System.out.println(jsonString);

      /*  Car car2 = gson.fromJson(jsonString, Car.class);
        System.out.println(car2);*/

    }

    public static CommonModel.GUUID asGrpcUuid(UUID api) throws SiteWhereException {
        if (api == null) {
            return null;
        }
        CommonModel.GUUID.Builder grpc = CommonModel.GUUID.newBuilder();
        grpc.setMsb(api.getMostSignificantBits());
        grpc.setLsb(api.getLeastSignificantBits());
        return grpc.build();
    }
}
