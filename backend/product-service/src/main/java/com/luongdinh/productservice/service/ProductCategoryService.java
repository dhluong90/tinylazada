package com.luongdinh.productservice.service;

import com.luongdinh.productservice.entity.ProductCategory;
import com.luongdinh.productservice.repository.ProductCategoryRepository;

public interface ProductCategoryService extends CRUDService<ProductCategory, Long, ProductCategoryRepository> {
    
}
