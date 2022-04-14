package org.example.mmm;

import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description 8点多的版本保留
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

    @Value("#{'${minio.defaultImages}'.split('-')}")
    private List<String> defaultImages;

    @Value("${minio.bucketName}")
    private String bucketName;

    @Value("${minio.prefixPath}")
    private String prefixPath;

    @Value("${minio.bucketPolicy}")
    private String bucketPolicy;


    MinioClient minioClient=null;
    /*
    @PostConstruct
    public void initDefaultData() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        minioClient =
                MinioClient.builder()
                        .endpoint(endpoint)
                        .credentials(accessKey, secretKey)
                        .build();
        if(!minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build())) {
            minioClient.makeBucket(MakeBucketArgs.builder()
                    .bucket(bucketName)
                    .build());
            minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket(bucketName).config(bucketPolicy).build());
            String property = System.getProperty("user.dir");
            defaultImages.forEach(e -> {
                try {
                    minioClient.uploadObject(
                            UploadObjectArgs.builder()
                                    .bucket(bucketName)
                                    .object("default" + e.trim())
                                    .filename(property + prefixPath + e.trim())
                                    .build());
                } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException | InvalidResponseException | IOException | NoSuchAlgorithmException | ServerException | XmlParserException ex) {
                    ex.printStackTrace();
                }
                log.info(e + " 已上传至miniO");
            });
        }
    }

     */

}
