package com.luongdinh.productservice.service;

import java.util.List;

import com.luongdinh.productservice.dto.ProductListResponse;
import com.luongdinh.productservice.entity.Product;
import com.luongdinh.productservice.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public List<ProductListResponse.Product> getProductsByPage(Pageable pageable) {
        Page<Product> productPage = productRepository.findAll(pageable);
        return null;
    }
}
