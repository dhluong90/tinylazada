package com.luongdinh.orderservice.repository;

import com.luongdinh.orderservice.entity.Order;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

}
