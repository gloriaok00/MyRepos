package com.example.demo.pingshi.datatype;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyu
 * @description list类型
 * @date 2020-10-12 15:26
 */

@RestController
public class ListDemo {

    public static List<Long> typeIds;

    @Value("#{'${iot.types}'.split(',')}")
    public void setTypeIds(List<Long> typeIds) {
        ListDemo.typeIds = typeIds;
    }

    @Value("${server.port}")
    private int port;

    public static void main(String[] args) {
        List<String> deviceList = new ArrayList<>();
        deviceList.add("1");
        deviceList.add("2");
        deviceList.add("3");

        if (deviceList.contains("2")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        String[] ss = (String[]) deviceList.toArray(new String[deviceList.size()]);
        //把array以string的形式展示出来，用ss.toString是不可以的，需要用Arrays工具类
        System.out.println(Arrays.toString(ss));

        StringBuilder sb = new StringBuilder();
        deviceList.forEach(e -> {
            sb.append(e + ",");
        });

        System.out.println(sb.substring(0, sb.length() - 1));
    }

    @GetMapping("/value/list")
    public void show(){
        System.out.println(port);
        typeIds.forEach(e-> System.out.println(e.longValue()));
    }
}
