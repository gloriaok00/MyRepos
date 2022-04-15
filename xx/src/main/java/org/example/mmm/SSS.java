package org.example.mmm;

import com.spire.xls.FileFormat;
import com.spire.xls.Workbook;
import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import io.minio.errors.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


/**
 * @description
 * @date 2022-04-14 20:34
 */

public class SSS {

    public static void save2pdf(String url,String bucketName,MinioClient minioClient) throws Exception {
        Workbook workbook = new Workbook();
        boolean flag = minioClient.bucketExists(bucketName);
        if (flag) {
            InputStream stream = minioClient.getObject(bucketName, url);
            workbook.loadFromStream(stream);
            workbook.getConverterSetting().setSheetFitToPage(true);
        }else{
            System.out.println("不存在相应的工艺数据:"+bucketName+url);
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.saveToStream(baos, FileFormat.PDF);
        InputStream in = new ByteArrayInputStream(baos.toByteArray());

        PutObjectOptions putObjectOptions = new PutObjectOptions(baos.size(), 5242880L);
        String newObjectName = url.replaceAll(".xlsx", ".pdf");
        String finalNewObjectName=newObjectName.replace("xls","pdf");
        //TODO 命名替换 子线程
        new Thread(() -> {
            try {
                minioClient.putObject(bucketName, finalNewObjectName, in, putObjectOptions);
                System.out.println(finalNewObjectName + "成功上传至minio");
            } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidBucketNameException | InvalidKeyException | InvalidResponseException | IOException | NoSuchAlgorithmException | XmlParserException e) {
                e.printStackTrace();
                System.out.println("工艺转换pdf出错"+finalNewObjectName);
            }
        }).start();
    }

    public static void main(String[] args) throws Exception{
        MinioClient client=new MinioClient("http://223.223.176.32:30711","OKw3bxT5me","AnI22zu!vu89FaJ");
        save2pdf("default/template/xls/zy.xlsx","iot",client);
    }
}
