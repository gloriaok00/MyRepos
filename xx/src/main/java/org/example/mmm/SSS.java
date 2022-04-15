package org.example.mmm;

import com.spire.xls.FileFormat;
import com.spire.xls.Workbook;
import io.minio.MinioClient;
import io.minio.ObjectStat;
import io.minio.PutObjectOptions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;


/**
 * @description
 * @date 2022-04-14 20:34
 */

public class SSS {

    public static String save2pdf(String accessKey, String secretKey, String url) throws Exception {
        String[] split = url.split("/");
        String endPoint = "http://" + split[2];
        String bucketName = split[3];
        String objectName = split[4] + "/" + split[5] + "/" + split[6];

        Workbook workbook = new Workbook();
        MinioClient minioClient = new MinioClient(endPoint, accessKey, secretKey);
        boolean flag = minioClient.bucketExists(bucketName);
        if (flag) {
            ObjectStat statObject = minioClient.statObject(bucketName, objectName);
            if (statObject != null && statObject.length() > 0) {
                InputStream stream = minioClient.getObject(bucketName, objectName);
                workbook.loadFromStream(stream);
                workbook.getConverterSetting().setSheetFitToPage(true);
            }
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.saveToStream(baos, FileFormat.PDF);
        InputStream in = new ByteArrayInputStream(baos.toByteArray());

        PutObjectOptions putObjectOptions = new PutObjectOptions(baos.size(), baos.size() >= 5242880L ? baos.size() : 0L);
        String newObjectName = objectName.replaceAll(".xlsx", ".pdf");
        minioClient.putObject(bucketName, newObjectName, in, putObjectOptions);
        return newObjectName;
    }

    public static void main(String[] args) throws Exception{
        save2pdf("OKw3bxT5me","AnI22zu!vu89FaJ","");
    }
}
