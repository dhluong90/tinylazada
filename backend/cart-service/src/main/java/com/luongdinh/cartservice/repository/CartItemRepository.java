package com.luongdinh.cartservice.repository;

import java.util.List;

import com.luongdinh.cartservice.entity.CartItem;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends PagingAndSortingRepository<CartItem, Long> {

    @Query("select c from CartItem c join c.userCard where c.userCard.userId = :userId")
    List<CartItem> findByUserId(@Param("userId") String userId);

    @Query("update CartItem C set C.delete = true where C.id in (:ids) and C.userCart exists (select U from UserCart U where U.userId = :userId)")
    void deleteByIdAndUserID(@Param("ids") List<Long> itemId, @Param("userId") Long userId);
}
