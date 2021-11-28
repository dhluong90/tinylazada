package com.luongdinh.orderservice.controller;

import javax.validation.Valid;

import com.luongdinh.orderservice.dto.OrderCreatedRequestDto;
import com.luongdinh.orderservice.dto.OrderCreatedResponseDto;
import com.luongdinh.orderservice.service.OrderService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    OrderService orderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderCreatedResponseDto> createOrder(
            @RequestBody @Valid OrderCreatedRequestDto orderCreatedRequestDto) {
        String userId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long orderId = orderService.create(orderCreatedRequestDto, Long.valueOf(userId));
        return ResponseEntity.status(HttpStatus.CREATED).body(OrderCreatedResponseDto.builder().id(orderId).build());
    }

}
