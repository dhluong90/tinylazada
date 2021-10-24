package com.luongdinh.productservice.repository;

import com.luongdinh.productservice.entity.ProductCategory;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends PagingAndSortingRepository<ProductCategory, Long> {

}
