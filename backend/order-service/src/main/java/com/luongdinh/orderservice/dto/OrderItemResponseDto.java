package com.luongdinh.orderservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemResponseDto {

    private Long id;
    private Long productId;
    private String productName;
    private String productBrand;
    private String productThumpnail;
    private Integer quantity;
}
