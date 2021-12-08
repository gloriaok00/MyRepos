package com.example.demo.pingshi.spring.myproperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description
 * @date 2021-12-08 21:44
 */

@ConfigurationProperties(prefix = "remote.connection")
@Data
public class RemoteProp {

    private String ip;
    private String name;
    private String password;

}
