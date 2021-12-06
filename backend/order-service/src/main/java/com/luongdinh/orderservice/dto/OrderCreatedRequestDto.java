package com.luongdinh.orderservice.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderCreatedRequestDto {

    @NotEmpty(message = "items list can not be empty")
    private List<OrderItemCreatedRequestDto> items;
}
