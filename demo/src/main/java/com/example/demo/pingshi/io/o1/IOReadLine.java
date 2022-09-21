package com.example.demo.pingshi.io.o1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @description InputStreamReader line用法
 * @date 2022/9/21 01:32
 */

public class IOReadLine {

    public static void main(String[] args) {

        try {
            InputStream stream = IOReadLine.class.getClassLoader().getResourceAsStream("application.properties");
            InputStreamReader in = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(in);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
