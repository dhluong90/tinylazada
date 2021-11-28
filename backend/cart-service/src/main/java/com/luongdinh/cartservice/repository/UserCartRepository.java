package com.luongdinh.cartservice.repository;

import java.util.Optional;

import com.luongdinh.cartservice.entity.UserCart;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCartRepository extends PagingAndSortingRepository<UserCart, Long> {

    Optional<UserCart> findByUserId(Long userId);

}
