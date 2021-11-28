package com.luongdinh.orderservice.mapper;

import com.luongdinh.orderservice.dto.OrderItemCreatedRequestDto;
import com.luongdinh.orderservice.dto.OrderItemResponseDto;
import com.luongdinh.orderservice.entity.OrderItem;
import com.luongdinh.tinylazada.common.sdk.product.response.ProductListResponseDto;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface OrderItemMapper {

    public OrderItem orderItemCreatedRequestToOrderItem(OrderItemCreatedRequestDto orderItemCreatedRequestDto);

    public OrderItemResponseDto orderItemToOrderItemResponse(OrderItemResponseDto orderItemResponseDto,
            ProductListResponseDto productListResponseDto);

}
