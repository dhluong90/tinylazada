package com.luongdinh.cartservice.controller;

import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import com.luongdinh.cartservice.dto.CartItemResponseDto;
import com.luongdinh.cartservice.dto.UserCartRequestDto;
import com.luongdinh.cartservice.dto.UserCartResponseDto;
import com.luongdinh.cartservice.entity.CartItem;
import com.luongdinh.cartservice.service.CartItemService;
import com.luongdinh.cartservice.service.UserCartService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/carts")
public class ShoppingCartController {

    UserCartService userCartService;
    CartItemService cartItemService;

    @PostMapping(name = "/addtocart", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserCartResponseDto> addToCard(@RequestBody UserCartRequestDto userCartRequestDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = (String) authentication.getPrincipal();
        userCartService.addProductToCart(userCartRequestDto, Long.valueOf(userId));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserCartResponseDto> getCartItems() {
        String userId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<CartItemResponseDto> userCartResponseDtos = cartItemService.getCartItemByUserId(userId);
        return ResponseEntity.ok(UserCartResponseDto.builder().items(userCartResponseDtos).build());
    }

    @DeleteMapping(name = "/{items}")
    public ResponseEntity<Void> deleteCartItem(@PathParam("items") List<Long> ids) {
        String userId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        cartItemService.delete(ids, Long.valueOf(userId));
        return ResponseEntity.ok().build();
    }
}
