package org.example.mmm;

import cn.hutool.http.HttpUtil;
import io.minio.*;
import io.minio.errors.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @description
 * @date 2022-04-12 16:13
 */

@Slf4j
@Component
public class MM {

    @Value("${minio.endpoint}")
    private String endpoint;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;


    MinioClient minioClient=null;

    public void upload() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        minioClient.uploadObject(
                UploadObjectArgs.builder()
                        .bucket("iot2")
                        .object("default/areaType/default_areaType.jpg")
                        .filename("/Users/zhangyu/Downloads/default_areaType.jpg")
                        .build());
        System.out.println("done");
    }

    public void uploadOthers() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        // Upload '/home/user/Photos/asiaphotos.zip' as object name 'asiaphotos-2015.zip' to bucket
        // 'asiatrip'.
        minioClient.uploadObject(
                UploadObjectArgs.builder()
                        .bucket("iot2")
                        .object("default/areaType/桌面.jpg")
                        .filename("/Users/zhangyu/Downloads/桌面.jpg")
                        .build());
        System.out.println("done");
    }

    @PostConstruct
    public void initDefaultData() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        minioClient =
                MinioClient.builder()
                        .endpoint(endpoint)
                        .credentials(accessKey, secretKey)
                        .build();
        boolean flag = minioClient.bucketExists(BucketExistsArgs.builder().bucket("iot2").build());
        if(!flag){
            minioClient.makeBucket(MakeBucketArgs.builder()
                    .bucket("iot2")
                    .build());
            String ss="{\"Version\":\"2012-10-17\",\"Statement\":[{\"Effect\":\"Allow\",\"Principal\":{\"AWS\":[\"*\"]},\"Action\":[\"s3:GetBucketLocation\",\"s3:ListBucket\",\"s3:ListBucketMultipartUploads\"],\"Resource\":[\"arn:aws:s3:::iot2\"]},{\"Effect\":\"Allow\",\"Principal\":{\"AWS\":[\"*\"]},\"Action\":[\"s3:DeleteObject\",\"s3:GetObject\",\"s3:ListMultipartUploadParts\",\"s3:PutObject\",\"s3:AbortMultipartUpload\"],\"Resource\":[\"arn:aws:s3:::iot2/*\"]}]}";
            minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket("iot2").config(ss).build());
            this.upload();
        }else{
            this.uploadOthers();
        }
    }


}
