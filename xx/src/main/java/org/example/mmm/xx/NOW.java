package org.example.mmm.xx;

import io.minio.MinioClient;
import io.minio.errors.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @description
 * @date 2022-04-12 16:13
 */

@Slf4j
@Component
public class NOW {

    @Value("${minio.endpoint}")
    private String endpoint;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;

    @Value("#{'${minio.defaultImages}'.split('-')}")
    private List<String> defaultImages;

    @Value("${minio.bucketName}")
    private String bucketName;

    @Value("${minio.prefixPath}")
    private String prefixPath;

    @Value("${minio.bucketPolicy}")
    private String bucketPolicy;


    MinioClient minioClient=null;

    //@PostConstruct
    public void initDefaultData() throws InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException, InvalidBucketNameException, RegionConflictException, InvalidPortException, InvalidEndpointException {
        minioClient = new MinioClient(endpoint,accessKey, secretKey);
        if(!minioClient.bucketExists(bucketName)) {
            minioClient.makeBucket(bucketName);
            minioClient.setBucketPolicy(bucketName,bucketPolicy);
            String property = System.getProperty("user.dir");
            defaultImages.forEach(e -> {
                try {
                    minioClient.putObject(bucketName, "default" + e.trim(),
                                    property + prefixPath + e.trim(),
                                    null);
                } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException | InvalidResponseException | IOException | NoSuchAlgorithmException | XmlParserException | InvalidBucketNameException ex) {
                    ex.printStackTrace();
                }
                log.info(e + " 已上传至miniO");
            });
        }
    }

}
