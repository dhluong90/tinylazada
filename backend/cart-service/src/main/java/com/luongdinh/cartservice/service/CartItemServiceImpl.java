package com.luongdinh.cartservice.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.luongdinh.cartservice.dto.CartItemResponseDto;
import com.luongdinh.cartservice.entity.CartItem;
import com.luongdinh.cartservice.mapper.CartItemMapper;
import com.luongdinh.cartservice.repository.CartItemRepository;
import com.luongdinh.tinylazada.common.dto.PageResponse;
import com.luongdinh.tinylazada.common.sdk.product.ProductServiceClient;
import com.luongdinh.tinylazada.common.sdk.product.response.ProductListResponseDto;
import com.luongdinh.tinylazada.common.service.AbstractCRUDService;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartItemServiceImpl extends AbstractCRUDService<CartItem, Long, CartItemRepository>
        implements CartItemService {

    private CartItemRepository cartItemRepository;
    private ProductServiceClient productServiceClient;
    private CartItemMapper cartItemMapper;

    @Override
    protected PagingAndSortingRepository<CartItem, Long> getEntityRepository() {
        return cartItemRepository;
    }

    @Override
    public List<CartItemResponseDto> getCartItemByUserId(String userId) {
        List<CartItem> cartItems = cartItemRepository.findByUserId(userId);
        List<Long> productIds = cartItems.stream().map(CartItem::getProductId).collect(Collectors.toList());
        PageResponse<ProductListResponseDto> products = productServiceClient.fetchProductListResponse(0, 1000,
                productIds);
        final Map<Long, ProductListResponseDto> productsMap = products.getContent().stream()
                .collect(Collectors.toMap(ProductListResponseDto::getId, i -> i));
        return cartItems.stream()
                .map(item -> cartItemMapper.toUserCardResponseDtoBy(item, productsMap.get(item.getProductId())))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(List<Long> ids, Long userId) {
        cartItemRepository.deleteByIdAndUserID(ids, userId);
    }

}
