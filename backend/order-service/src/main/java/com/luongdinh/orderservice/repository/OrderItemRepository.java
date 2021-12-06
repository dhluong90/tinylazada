package com.luongdinh.orderservice.repository;

import com.luongdinh.orderservice.entity.OrderItem;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends PagingAndSortingRepository<OrderItem, Long> {

}
