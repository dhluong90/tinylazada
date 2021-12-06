package com.luongdinh.cartservice.mapper;

import com.luongdinh.cartservice.dto.CartItemResponseDto;
import com.luongdinh.cartservice.dto.UserCartRequestDto;
import com.luongdinh.cartservice.entity.CartItem;
import com.luongdinh.tinylazada.common.sdk.product.response.ProductListResponseDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface CartItemMapper {

    CartItem toCartItemBy(UserCartRequestDto userCartRequestDto);

    @Mapping(source = "productListResponseDto.productName", target = "productName")
    @Mapping(source = "productListResponseDto.brandName", target = "brandName")
    @Mapping(source = "productListResponseDto.price", target = "price")
    @Mapping(source = "productListResponseDto.imageUrl", target = "thumnailUrl")
    @Mapping(source = "cartItem.id", target = "id")
    CartItemResponseDto toUserCardResponseDtoBy(CartItem cartItem, ProductListResponseDto productListResponseDto);
}
