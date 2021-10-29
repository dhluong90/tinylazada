package com.luongdinh.productservice.dto;

import lombok.Data;

@Data
public class ProductListResponse {

    private Long id;
    private String productName;
    private String imgeUrl;
    private Double averageStar;
    private Long totalReview;
}
