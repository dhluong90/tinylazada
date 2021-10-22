package com.luongdinh.productservice.service;

import com.luongdinh.productservice.dto.ProductListResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ProductService {
    
    public Page<ProductListResponse.Product> getProductsByPage(PageRequest pageable); 
}
