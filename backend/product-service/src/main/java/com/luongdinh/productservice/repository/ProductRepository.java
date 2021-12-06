package com.luongdinh.productservice.repository;

import com.luongdinh.productservice.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository
        extends PagingAndSortingRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    Page<Product> findAll(Pageable pageable);
}
