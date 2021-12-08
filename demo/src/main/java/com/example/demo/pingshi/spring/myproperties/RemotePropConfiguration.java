package com.example.demo.pingshi.spring.myproperties;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description
 * @date 2021-12-08 21:56
 */
@Configuration
@EnableConfigurationProperties(RemoteProp.class)
@ConditionalOnProperty(prefix = "remote.connection",value = "enabled")
public class RemotePropConfiguration {
}
