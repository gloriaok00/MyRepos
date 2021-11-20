package com.example.demo.pingshi.spring.myproperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description 学习@co
 * @date 2021-11-20 17:43
 */

@RestController
public class MainConnection {

    @Autowired
    private ConnProp connProp;

    @Resource(name = "connProp2")
    private ConnProp connProp2;

    @GetMapping("/connprop")
    public void show(){
        System.out.println("=====test1:==========");
        System.out.println(connProp.getRemoteIP());
        System.out.println(connProp.getName());
        System.out.println(connProp.getPassword());
        System.out.println("=====test2:==========");
        System.out.println(connProp2.getRemoteIP());
        System.out.println(connProp2.getName());
        System.out.println(connProp2.getPassword());
    }

}

@ConfigurationProperties(prefix = "conn")
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
class ConnProp{

    private String remoteIP;
    private String name;
    private String password;


    @Bean("connProp2")
    public ConnProp getDefaultConnProp(){
        return new ConnProp(remoteIP,name,password);
    }

}
