package com.luongdinh.orderservice.dto;

import java.math.BigDecimal;
import java.util.List;

import com.luongdinh.orderservice.entity.OrderItem;

import org.springframework.stereotype.Service;

@Service
public class OrderAmountCalculationServiceImpl implements OrderAmountCalculationService {

    @Override
    public BigDecimal calOrderAmount(List<OrderItem> items) {
        return items.stream().map(i -> i.getPrice().multiply(BigDecimal.valueOf(i.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
