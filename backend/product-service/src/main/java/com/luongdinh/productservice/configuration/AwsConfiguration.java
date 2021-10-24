package com.luongdinh.productservice.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfiguration {

    @Bean
    public AmazonS3 s3(TinyLazadaProperties tinyLazadaProperties) {
        AWSCredentials awsCredentials = new BasicAWSCredentials(tinyLazadaProperties.getAws().getAccessKey(),
                tinyLazadaProperties.getAws().getSecretKey());
        return AmazonS3ClientBuilder.standard().withRegion(tinyLazadaProperties.getAws().getRegion())
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();

    }
}
