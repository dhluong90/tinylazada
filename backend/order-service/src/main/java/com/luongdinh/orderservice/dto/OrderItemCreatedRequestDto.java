package com.luongdinh.orderservice.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemCreatedRequestDto {

    @NotNull(message = "productID is required")
    private Long productId;
    @NotNull(message = "product price is required")
    private BigDecimal price;
    @NotNull(message = "quantity is required")
    private Integer quantity;
}
