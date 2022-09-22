package com.example.demo.pingshi.io.o1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

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
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile file = req.getFile("file");
        InputStream inputStream = file.getInputStream();
        OutputStream outputStream = new FileOutputStream("/Users/zhangyu/file-" + System.currentTimeMillis() + ".txt");

        byte[] bs = new byte[1024];
        int i;
        while ((i = inputStream.read(bs)) != -1) {
            outputStream.write(bs, 0, i);
        }
    }

    //从本地文件中下载
    @GetMapping("/download")
    public String fileDownLoad(HttpServletResponse response) {
        File file = new File("/Users/zhangyu/Desktop/test.txt");
        if (!file.exists()) {
            return "下载文件不存在";
        }
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            byte[] buff = new byte[1024];
            OutputStream os = response.getOutputStream();
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            log.error("{}", e);
            return "下载失败";
        }
        return "下载成功";
    }

    //从网络获取并下载
    @RequestMapping("/netDownloadLocal")
    public void downloadNet(String netAddress) throws IOException {
        URL httpurl=new URL("http://223.223.176.32:30711/iot/zy_t1/tenant/%E6%88%AA%E5%B1%8F2022-07-18%2011.35.04.png?Content-Disposition=attachment%3B%20filename%3D%22zy_t1%2Ftenant%2F%E6%88%AA%E5%B1%8F2022-07-18%2011.35.04.png%22&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=OKw3bxT5me%2F20220922%2F%2Fs3%2Faws4_request&X-Amz-Date=20220922T014318Z&X-Amz-Expires=432000&X-Amz-SignedHeaders=host&X-Amz-Signature=a7294b909aaa64fdf173aaa92d2f02423c1768d45ae00791cd0429b762ebb00d");
        HttpURLConnection httpConn=(HttpURLConnection)httpurl.openConnection();

        //URLConnection conn = url.openConnection();
        //File file=new File("/Users/zhangyu/Downloads/截屏2022-07-18 11.35.04.png");
        InputStream inputStream = httpConn.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/zhangyu/22.png");

        int bytesum = 0;
        int byteread;
        byte[] buffer = new byte[1024];
        while ((byteread = inputStream.read(buffer)) != -1) {
            bytesum += byteread;
            System.out.println(bytesum);
            fileOutputStream.write(buffer, 0, byteread);
        }
        fileOutputStream.close();
    }


}
