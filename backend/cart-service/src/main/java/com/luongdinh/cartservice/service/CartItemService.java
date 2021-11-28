package com.luongdinh.cartservice.service;

import java.util.List;

import com.luongdinh.cartservice.dto.CartItemResponseDto;
import com.luongdinh.cartservice.entity.CartItem;
import com.luongdinh.cartservice.repository.CartItemRepository;
import com.luongdinh.tinylazada.common.service.CRUDService;

public interface CartItemService extends CRUDService<CartItem, Long, CartItemRepository> {

    /**
     * get all the cart items in this user shoping cart
     * 
     * @param userId
     * @return
     */
    List<CartItemResponseDto> getCartItemByUserId(String userId);

    /**
     * Delete list of cart items by ids
     * 
     * @param ids
     */
    void delete(List<Long> ids, Long userId);
}
