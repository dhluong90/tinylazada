package com.luongdinh.productservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaAuditConfiguration {
    
    @Bean
    public CustomAuditAware auditorProvider(TinyLazadaProperties tinyLazadaProperties) {
        return  new CustomAuditAware(tinyLazadaProperties);
    }
}
