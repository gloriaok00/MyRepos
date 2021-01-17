package com.example.demo.pingshi.io;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author zhangyu
 * @description
 * @date 2021-01-08 10:45
 */

public class ReadByteFromFile {

    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new FileReader("/Users/zhangyu/IdeaProjects/MyRepos/demo/src/main/resources/aa.yml"));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        // 删除最后一个新行分隔符
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        reader.close();
        String content = stringBuilder.toString();
        System.out.println(content);
    }
}
