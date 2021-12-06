package com.luongdinh.productservice.repository;

import com.luongdinh.productservice.entity.Mall;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MallRepository extends PagingAndSortingRepository<Mall, Long> {

}
