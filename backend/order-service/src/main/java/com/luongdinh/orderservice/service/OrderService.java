package com.luongdinh.orderservice.service;

import com.luongdinh.orderservice.dto.OrderCreatedRequestDto;
import com.luongdinh.orderservice.entity.Order;
import com.luongdinh.orderservice.repository.OrderRepository;
import com.luongdinh.tinylazada.common.service.CRUDService;

public interface OrderService extends CRUDService<Order, Long, OrderRepository> {

    public Long create(OrderCreatedRequestDto orderCreatedRequestDto, Long userId);

}
