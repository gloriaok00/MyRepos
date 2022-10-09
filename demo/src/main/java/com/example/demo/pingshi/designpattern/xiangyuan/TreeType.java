package com.example.demo.pingshi.designpattern.xiangyuan;

import lombok.Data;

@Data
public class TreeType {

    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

}
