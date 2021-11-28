package com.luongdinh.cartservice.service;

import com.luongdinh.cartservice.dto.UserCartRequestDto;
import com.luongdinh.cartservice.entity.UserCart;
import com.luongdinh.cartservice.repository.UserCartRepository;
import com.luongdinh.tinylazada.common.service.CRUDService;

public interface UserCartService extends CRUDService<UserCart, Long, UserCartRepository> {

    public void addProductToCart(UserCartRequestDto userCartRequestDto, Long userId);
}
