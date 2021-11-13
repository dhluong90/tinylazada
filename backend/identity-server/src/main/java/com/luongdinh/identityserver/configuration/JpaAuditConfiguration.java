package com.luongdinh.identityserver.configuration;

import com.luongdinh.tinylazada.common.configuration.CustomAuditAware;
import com.luongdinh.tinylazada.common.configuration.TinyLazadaProperties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaAuditConfiguration {

    @Bean
    public CustomAuditAware auditorProvider(TinyLazadaProperties tinyLazadaProperties) {
        return new CustomAuditAware(tinyLazadaProperties);
    }
}
