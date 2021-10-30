package com.luongdinh.productservice.dto;

import java.util.Objects;

import com.luongdinh.productservice.entity.Mall;

import org.bouncycastle.pqc.jcajce.provider.rainbow.SignatureSpi.withSha224;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MallResponseDto {
    private Long id;
    private String name;
    private String logoUrl;

    public static MallResponseDto fromMall(Mall mall) {
        if (Objects.isNull(mall))
            return null;
        return MallResponseDto.builder().id(mall.getId()).logoUrl(mall.getLogo().getUrl()).name(mall.getName()).build();
    }
}
