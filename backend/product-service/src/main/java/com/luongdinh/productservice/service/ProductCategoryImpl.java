package com.luongdinh.productservice.service;

import com.luongdinh.productservice.entity.ProductCategory;
import com.luongdinh.productservice.repository.ProductCategoryRepository;

import org.springframework.stereotype.Service;

@Service
public class ProductCategoryImpl extends AbstractCRUDService<ProductCategory, Long, ProductCategoryRepository>
        implements ProductCategoryService {

    ProductCategoryRepository productCategoryRepository;

    public ProductCategoryImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    protected ProductCategoryRepository getEntityRepository() {
        return this.productCategoryRepository;
    }

}
