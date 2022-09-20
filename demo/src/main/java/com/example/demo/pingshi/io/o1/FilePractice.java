package com.example.demo.pingshi.io.o1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @description io以及上传文件练习
 * @date 2022/9/20 15:26
 */

@Slf4j
@RequestMapping("/file")
@RestController
public class FilePractice {

    public static File MultipartFileToFile(MultipartFile multiFile) {
        // 获取文件名
        String fileName = multiFile.getOriginalFilename();
        // 获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        // 若需要防止生成的临时文件重复,可以在文件名后添加随机码

        try {
            File file = File.createTempFile(fileName, prefix);
            multiFile.transferTo(file);
            return file;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //普通的文本@RequestParam可以不加名称 但file得加
    @GetMapping("/param")
    public void show(@RequestParam String param, @RequestParam("myFile") MultipartFile file) throws Exception {
        File file2 = MultipartFileToFile(file);
        FileInputStream inputStream = new FileInputStream(file2);
        Long now = System.currentTimeMillis();
        FileOutputStream outputStream = new FileOutputStream("/Users/zhangyu/file-" + now + ".txt");
        byte[] bytes = new byte[1024];
        int i;
        while ((i = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, i);
        }
        System.out.println("结束:" + param);
        outputStream.close();
        inputStream.close();
    }
}
