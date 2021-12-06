package com.luongdinh.orderservice.service;

import com.luongdinh.orderservice.entity.OrderItem;
import com.luongdinh.orderservice.repository.OrderItemRepository;
import com.luongdinh.tinylazada.common.service.AbstractCRUDService;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderItemServiceImpl extends AbstractCRUDService<OrderItem, Long, OrderItemRepository>
        implements OrderItemService {

    private OrderItemRepository orderItemRepository;

    @Override
    protected PagingAndSortingRepository<OrderItem, Long> getEntityRepository() {
        return orderItemRepository;
    }

}
