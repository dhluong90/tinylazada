package com.luongdinh.cartservice.dto;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class CartItemResponseDto {
    private String productName;
    private String brandName;
    private String thumnailUrl;
    private Long id;
    private Long productId;
    private BigDecimal price;
    private Long quantity;
}
