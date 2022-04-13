package org.example.mmm;

import cn.hutool.http.HttpUtil;
import io.minio.*;
import io.minio.errors.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.ServerException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @description
 * @date 2022-04-12 16:13
 */

public class MM {

   static MinioClient minioClient =
            MinioClient.builder()
                    .endpoint("http://223.223.176.32:30711")
                    .credentials("OKw3bxT5me", "AnI22zu!vu89FaJ")
                    .build();


    /* @Test
    public void upload() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException{
        // Make 'asiatrip' bucket if not exist.

        boolean found =
                minioClient.bucketExists(BucketExistsArgs.builder().bucket("iot").build());
        if (!found) {
            // Make a new bucket called 'asiatrip'.
            minioClient.makeBucket(MakeBucketArgs.builder().bucket("iot").build());
        } else {
            System.out.println("Bucket 'iot' already exists.");
        }

        // Upload '/home/user/Photos/asiaphotos.zip' as object name 'asiaphotos-2015.zip' to bucket
        // 'asiatrip'.
        minioClient.uploadObject(
                UploadObjectArgs.builder()
                        .bucket("iot")
                        .object("zytest.txt")
                        .filename("/Users/zhangyu/zytest.txt")
                        .build());
        System.out.println("done");
    }*/
    public static void main(String[] args) throws Exception {
        boolean flag = minioClient.bucketExists(BucketExistsArgs.builder().bucket("iot2").build());
        if(!flag){
            minioClient.makeBucket(MakeBucketArgs.builder()
                    .bucket("iot2")
                    .build());
            String ss="{\"Version\":\"2012-10-17\",\"Statement\":[{\"Effect\":\"Allow\",\"Principal\":{\"AWS\":[\"*\"]},\"Action\":[\"s3:GetBucketLocation\",\"s3:ListBucket\",\"s3:ListBucketMultipartUploads\"],\"Resource\":[\"arn:aws:s3:::iot2\"]},{\"Effect\":\"Allow\",\"Principal\":{\"AWS\":[\"*\"]},\"Action\":[\"s3:DeleteObject\",\"s3:GetObject\",\"s3:ListMultipartUploadParts\",\"s3:PutObject\",\"s3:AbortMultipartUpload\"],\"Resource\":[\"arn:aws:s3:::iot2/*\"]}]}";
            minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket("iot2").config(ss).build());
        }
    }


}
