package com.example.demo.pingshi.myannotation;

/**
 * @description 自定义注解学习
 * @date 2022-05-03 13:07
 */

@DBTable(name = "MEMBER")
public class Member {

    //主键ID
    @SQLString(name = "ID", value = 50, constraint = @Constraints(primaryKey = true))
    private String id;

    @SQLString(name = "NAME", value = 30)
    private String name;

    @SQLInteger(name = "AGE")
    private int age;

    @SQLString(name = "DESCRIPTION", value = 150, constraint = @Constraints(allowNull = true))
    private String description;

}
