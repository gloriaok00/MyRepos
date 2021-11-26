package com.macro.cloud.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class User {

    private Long id;
    private String username;
    private String password;

}
