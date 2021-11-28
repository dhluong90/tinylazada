package com.luongdinh.tinylazada.common.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;

@ConfigurationProperties("tinylazada")
@Component
@Getter
public class TinyLazadaProperties {

    private String systemUserName;
    private Integer test;
    private AWS aws;
    private JWT jwt;

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

    @Data
    public static class JWT {
        private String secretKey;
        private Long expiredInSecond;
        private String header;
        private String prefix;
        private Claim claim;
    }

    @Data
    public static class Claim {
        private String userName;
    }
}
