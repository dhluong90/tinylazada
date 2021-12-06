package com.luongdinh.productservice.repository;

import com.luongdinh.productservice.entity.ProductReview;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReviewRepository extends CrudRepository<ProductReview, Long> {
    
}
