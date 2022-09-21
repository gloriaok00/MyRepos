package com.example.demo.pingshi.io.o1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
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
    @PostMapping("/upload")
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

    //上传文件的第二种方式，通过request转化
    @PostMapping("/upload2")
    public void show(HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest req=(MultipartHttpServletRequest)request;
        MultipartFile file = req.getFile("file");
        InputStream inputStream = file.getInputStream();
        OutputStream outputStream = new FileOutputStream("/Users/zhangyu/file-" + System.currentTimeMillis() + ".txt");

        byte[] bs = new byte[1024];
        int i;
        while ((i = inputStream.read(bs)) != -1) {
            outputStream.write(bs, 0, i);
        }
    }

}
