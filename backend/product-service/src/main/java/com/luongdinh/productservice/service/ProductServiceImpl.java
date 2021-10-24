package com.luongdinh.productservice.service;

import com.luongdinh.productservice.dto.ProductListResponse;
import com.luongdinh.productservice.entity.Product;
import com.luongdinh.productservice.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends AbstractCRUDService<Product, Long, ProductRepository>
        implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<ProductListResponse.Product> getProductsByPage(PageRequest pageRequest) {
        Page<Product> productPage = productRepository.findAll(pageRequest);
        return productPage.map(ProductListResponse.Product::fromProduct);
    }

    @Override
    protected ProductRepository getEntityRepository() {
        return productRepository;
    }
}
