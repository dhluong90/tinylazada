package com.luongdinh.orderservice.dto;

import java.sql.Timestamp;
import java.util.List;

import com.amazonaws.services.outposts.model.OrderStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderListResponseDto {

    private Long id;
    private Timestamp orderedDate;
    private OrderStatus orderStatus;
    private List<OrderItemResponseDto> orderItems;
}
