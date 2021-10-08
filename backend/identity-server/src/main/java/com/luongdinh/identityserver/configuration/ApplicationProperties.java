package com.luongdinh.identityserver.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "apigateway")
@Getter
@Setter
public class ApplicationProperties {

    private String whiteIpList;
}
