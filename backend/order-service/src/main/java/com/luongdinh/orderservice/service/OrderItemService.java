package com.luongdinh.orderservice.service;

import com.luongdinh.orderservice.entity.OrderItem;
import com.luongdinh.orderservice.repository.OrderItemRepository;
import com.luongdinh.tinylazada.common.service.CRUDService;

public interface OrderItemService extends CRUDService<OrderItem, Long, OrderItemRepository> {

}
