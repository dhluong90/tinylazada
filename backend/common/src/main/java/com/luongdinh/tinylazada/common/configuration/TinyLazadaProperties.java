package com.luongdinh.tinylazada.common.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties("tinylazada")
@Component
@Data
public class TinyLazadaProperties {

    private String systemUserName;
    private Integer test;
    private AWS aws;

    @Data
    public static class AWS {
        private String accessKey;
        private String secretKey;
        private String region;
        private S3 s3;
    }

    @Data
    public static class S3 {
        private String bucketName;
        private String publicImgPath;
        private String hostName;
    }
}
