package com.luongdinh.tinylazada.common.configuration;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class CustomAuditAware implements AuditorAware<String> {

    private TinyLazadaProperties tinyLazadaProperties;

    public CustomAuditAware(TinyLazadaProperties tinyLazadaProperties) {
        this.tinyLazadaProperties = tinyLazadaProperties;
    }

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(tinyLazadaProperties.getSystemUserName());
    }

}
