package com.luongdinh.productservice.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductListResponseDto {

    private Long id;
    private String productName;
    private String imageUrl;
    private Double averageStar;
    private Integer totalReview;
    private String brandName;
    private BigDecimal price;
}
