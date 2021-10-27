package com.example.demo.pingshi.tree;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Node{

    public String id ;
    public String name;
    public String parentId;

}
