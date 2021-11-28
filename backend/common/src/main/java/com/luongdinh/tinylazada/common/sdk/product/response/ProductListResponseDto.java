package com.luongdinh.tinylazada.common.sdk.product.response;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductListResponseDto {

    private Long id;
    private String productName;
    private String imgeUrl;
    private Double averageStar;
    private Integer totalReview;
    private String brandName;
    private BigDecimal price;
}
