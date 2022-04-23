package com.example.demo.pingshi.mylombok.lom;

import lombok.Data;
import lombok.EqualsAndHashCode;

//父类的属性是否参与equals比较
@EqualsAndHashCode(callSuper = true)
@Data
public class LChild extends LParent {

    private String name;

}
