package com.luongdinh.cartservice.repository;

import java.util.List;

import com.luongdinh.cartservice.entity.CartItem;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends PagingAndSortingRepository<CartItem, Long> {

    List<CartItem> findByUserCart_id(@Param("userId") String userId);

    @Query("update CartItem C set C.deleted = true where C.id in (:ids) and C.userCart in (select U from UserCart U where U.userId = :userId)")
    void deleteByIdAndUserID(@Param("ids") List<Long> itemId, @Param("userId") Long userId);
}
