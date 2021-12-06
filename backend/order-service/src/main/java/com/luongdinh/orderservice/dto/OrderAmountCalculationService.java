package com.luongdinh.orderservice.dto;

import java.math.BigDecimal;
import java.util.List;

import com.luongdinh.orderservice.entity.OrderItem;

public interface OrderAmountCalculationService {

    BigDecimal calOrderAmount(List<OrderItem> items);
}
