package com.luongdinh.productservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("tinylazada")
@Component

public class TinyLazadaProperties {

    private Integer test;
        public Integer getTest() {
        return this.test;
    }

    public void setTest(Integer test) {
        this.test = test;
    }
}


