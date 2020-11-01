package com.example.demo.pingshi.树形聚合;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Node{

    public String id ;
    public String name;
    public String parentId;

}