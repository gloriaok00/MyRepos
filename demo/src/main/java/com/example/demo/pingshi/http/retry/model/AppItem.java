package com.example.demo.pingshi.http.retry.model;

import lombok.Data;

@Data
public class AppItem {

    private Long id;
    private String appuuid;
    private String projectname;
    private String createtime;
    private int isCollection;
    private String remarks;
    private int version;

}
