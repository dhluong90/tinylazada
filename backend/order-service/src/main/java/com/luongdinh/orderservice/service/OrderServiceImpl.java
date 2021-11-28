package com.luongdinh.orderservice.service;

import java.util.List;
import java.util.stream.Collectors;

import com.luongdinh.orderservice.dto.OrderAmountCalculationService;
import com.luongdinh.orderservice.dto.OrderCreatedRequestDto;
import com.luongdinh.orderservice.entity.Order;
import com.luongdinh.orderservice.entity.OrderItem;
import com.luongdinh.orderservice.enumtype.OrderStatus;
import com.luongdinh.orderservice.mapper.OrderItemMapper;
import com.luongdinh.orderservice.repository.OrderRepository;
import com.luongdinh.tinylazada.common.service.AbstractCRUDService;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderServiceImpl extends AbstractCRUDService<Order, Long, OrderRepository> implements OrderService {

    private OrderRepository orderRepository;
    private OrderItemMapper orderItemMapper;
    private OrderAmountCalculationService orderAmountCalculationService;

    @Override
    protected PagingAndSortingRepository<Order, Long> getEntityRepository() {
        return orderRepository;
    }

    @Override
    public Long create(OrderCreatedRequestDto orderCreatedRequestDto, Long userId) {
        List<OrderItem> orderItems = orderCreatedRequestDto.getItems().stream()
                .map(orderItemMapper::orderItemCreatedRequestToOrderItem).collect(Collectors.toList());
        Order order = Order.builder().totalAmount(orderAmountCalculationService.calOrderAmount(orderItems))
                .userId(userId).status(OrderStatus.NEW).build();
        order = save(order);
        for (OrderItem item : orderItems) {
            item.setOrder(order);
        }
        return order.getId();
    }

}
