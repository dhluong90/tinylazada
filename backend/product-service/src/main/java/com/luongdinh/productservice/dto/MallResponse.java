package com.luongdinh.productservice.dto;

import com.luongdinh.productservice.entity.Mall;

import org.bouncycastle.pqc.jcajce.provider.rainbow.SignatureSpi.withSha224;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MallResponse {
    private Long id;
    private String name;
    private String logoUrl;

    public static MallResponse fromMall(Mall mall) {
        return MallResponse.builder().id(mall.getId()).logoUrl(mall.getLogo().getUrl()).name(mall.getName()).build();
    }
}
