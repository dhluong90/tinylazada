package com.luongdinh.productservice.service;

import com.luongdinh.productservice.dto.ProductListResponse;
import com.luongdinh.productservice.entity.Product;
import com.luongdinh.productservice.repository.ProductRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ProductService extends CRUDService<Product, Long, ProductRepository> {
    
    public Page<ProductListResponse.Product> getProductsByPage(PageRequest pageable); 
}
