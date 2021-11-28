package com.luongdinh.orderservice.mapper;

import com.luongdinh.orderservice.dto.OrderCreatedRequestDto;
import com.luongdinh.orderservice.entity.Order;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface OrderMapper {

    Order orderCreatedRequestToOrder(OrderCreatedRequestDto orderCreatedRequestDto);
}
