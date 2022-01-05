package com.example.demo.pingshi.rest;

import java.lang.reflect.Field;

public class MyUtil {

    public static void main(String[] args) throws Exception {
        PersonImportDTO personImportDTO = new PersonImportDTO("zhangyu", "12");
        PersonImportDTO person = new PersonImportDTO();
        Field field = personImportDTO.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(person, "dddd");
        System.out.println(person.getName());
    }

}
