package com.luongdinh.cartservice.service;

import java.util.Optional;

import com.luongdinh.cartservice.dto.UserCartRequestDto;
import com.luongdinh.cartservice.entity.CartItem;
import com.luongdinh.cartservice.entity.UserCart;
import com.luongdinh.cartservice.mapper.CartItemMapper;
import com.luongdinh.cartservice.repository.UserCartRepository;
import com.luongdinh.tinylazada.common.service.AbstractCRUDService;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserCartServiceImpl extends AbstractCRUDService<UserCart, Long, UserCartRepository>
        implements UserCartService {

    private UserCartRepository userCartRepository;
    private CartItemMapper cartItemMapper;

    @Override
    protected PagingAndSortingRepository<UserCart, Long> getEntityRepository() {
        return userCartRepository;
    }

    @Override
    public void addProductToCart(UserCartRequestDto userCartRequestDto, Long userId) {
        Optional<UserCart> userCartOpt = userCartRepository.findById(userId);
        if (userCartOpt.isEmpty()) {
            userCartOpt = Optional.of(this.save(UserCart.builder().userId(userId).build()));
        }
        CartItem cartItem = cartItemMapper.toCartItemBy(userCartRequestDto);
        cartItem.setUserCart(userCartOpt.get());
    }

}
